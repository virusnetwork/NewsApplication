package com.example.newsapplication.settings

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
import com.example.newsapplication.main.MainActivity
import com.example.newsapplication.R
import com.example.newsapplication.followingActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth


class SettingsAcitvity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.setting_windows)
        mAuth = FirebaseAuth.getInstance()
        setUp()
        navBar()

        findViewById<Button>(R.id.sign_up_button).setOnClickListener {
            val emailText = findViewById<EditText>(R.id.editTextTextEmailAddress).text.toString()
            val passwordText = findViewById<EditText>(R.id.editTextTextPassword).text.toString()
            signUp(emailText, passwordText)
        }

        findViewById<Button>(R.id.sign_in_button).setOnClickListener {
            val emailText = findViewById<EditText>(R.id.editTextTextEmailAddress).text.toString()
            val passwordText = findViewById<EditText>(R.id.editTextTextPassword).text.toString()
            signInUser(emailText, passwordText)
        }

        findViewById<SwitchCompat>(R.id.dataSaverSwitch).setOnCheckedChangeListener { _, isChecked ->
            if (isChecked)
                getSharedPreferences("userprofile", Context.MODE_PRIVATE).edit()
                    .putBoolean("datamode", true).apply()
            else getSharedPreferences("userprofile", Context.MODE_PRIVATE).edit()
                .putBoolean("datamode", false).apply()
        }

        findViewById<SwitchCompat>(R.id.darkModeSwitch).setOnCheckedChangeListener { _, isChecked ->
            if (isChecked)
                getSharedPreferences("userprofile", Context.MODE_PRIVATE).edit()
                    .putBoolean("darkmode", true).apply()
            else getSharedPreferences("userprofile", Context.MODE_PRIVATE).edit()
                .putBoolean("darkmode", false).apply()
        }

        findViewById<Spinner>(R.id.countryDropDown).onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                p0: AdapterView<*>?, p1: View?, p2: Int, p3:
                Long
            ) {
                getSharedPreferences("userprofile", Context.MODE_PRIVATE).edit()
                    .putInt("country", p2).apply()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}

        }
    }

    private fun setUp() {
        val userPref = getSharedPreferences("userprofile", Context.MODE_PRIVATE)
        findViewById<SwitchCompat>(R.id.darkModeSwitch).isChecked =
            userPref.getBoolean("darkmode", false)
        findViewById<SwitchCompat>(R.id.dataSaverSwitch).isChecked =
            userPref.getBoolean("datamode", false)



        setSpinner()
    }

    private fun setSpinner() {
        val countries = resources.getStringArray(R.array.countryDropDownItems)

        val spinner = findViewById<Spinner>(R.id.countryDropDown)
        if (spinner != null) {
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, countries)
            spinner.adapter = adapter
        }
        findViewById<Spinner>(R.id.countryDropDown).setSelection(
            getSharedPreferences("userprofile", Context.MODE_PRIVATE).getInt("country", 0)
        )
    }

    private fun signInUser(emailText: String, passwordText: String) {

        val btnLogin = findViewById<Button>(R.id.sign_in_button)
        btnLogin.setOnClickListener { view ->
            mAuth = FirebaseAuth.getInstance()
            mAuth.signInWithEmailAndPassword(
                emailText,
                passwordText
            )
                .addOnCompleteListener(
                    this
                ) { task ->
                    if (task.isSuccessful) {
                        val user = mAuth.currentUser
                        if (getSharedPreferences("userprofile", Context.MODE_PRIVATE).getString(
                                "username",
                                "defValue"
                            ) == "defValue"
                        ) {
                            val sharedPreference =
                                getSharedPreferences("userprofile", Context.MODE_PRIVATE).edit()
                            sharedPreference.putString("username", emailText)
                                .apply()
                            sharedPreference.putString("password", passwordText)
                                .apply()
                        }
                        findViewById<Button>(R.id.editTextTextEmailAddress).isEnabled = false
                        findViewById<Button>(R.id.editTextTextPassword).isEnabled = false
                        btnLogin.isEnabled = false
                        findViewById<Button>(R.id.sign_up_button).isEnabled = false
                    } else {
                        println("Can't login")
                    }
                }
        }


    }

    private fun signUp(emailText: String, passwordText: String) {

        val btnSignUp = findViewById<Button>(R.id.sign_up_button)
        btnSignUp.setOnClickListener { view ->
            mAuth = FirebaseAuth.getInstance()
            mAuth.createUserWithEmailAndPassword(
                emailText,
                passwordText
            )
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        val user = mAuth.currentUser
                        val sharedPreference =
                            getSharedPreferences("userprofile", Context.MODE_PRIVATE)
                        sharedPreference.edit().putString("username", emailText).apply()
                        sharedPreference.edit().putString("password", passwordText).apply()
                        signInUser(emailText, passwordText)
                    } else {
                        // If sign in fails, display a message to the user.
                        println("Can't sign up")
                    }
                }
        }
    }

    private fun logedIn() {
        //TODO stop user entering text to email/password
        //TODO make sign in button say sign out
        //TODO hide create account button
    }

    private fun navBar() {
        val bnv: BottomNavigationView =
            findViewById<BottomNavigationView>(R.id.bottomNav) as BottomNavigationView
        val followingIntent = Intent(this, followingActivity::class.java)
        val mainActivityIntent = Intent(this, MainActivity::class.java)
        val settingActivityIntent = Intent(this, SettingsAcitvity::class.java)

        bnv.setOnNavigationItemSelectedListener { item ->
            when (item.getItemId()) {
                R.id.favItem -> startActivity(followingIntent)
                R.id.followItem -> startActivity(followingIntent)
                R.id.worldItem -> startActivity(mainActivityIntent)
                R.id.settingItem -> startActivity(settingActivityIntent)

            }
            true
        }
    }

}