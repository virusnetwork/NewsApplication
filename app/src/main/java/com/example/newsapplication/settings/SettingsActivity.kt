package com.example.newsapplication.settings

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.SwitchCompat
import com.example.newsapplication.R
import com.example.newsapplication.following.FollowingActivity
import com.example.newsapplication.main.MainActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth


class SettingsActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.setting_windows)
        mAuth = FirebaseAuth.getInstance()

        val user = FirebaseAuth.getInstance().currentUser
        if (user != null) {
            // User is signed in
            button()
        }

        setUp()
        navBar()
        setImgButton()
        initaliseImgButton()

        findViewById<Button>(R.id.sign_up_button).setOnClickListener {
            val emailText = findViewById<EditText>(R.id.editTextEmailAddress).text.toString()
            val passwordText = findViewById<EditText>(R.id.editTextTextPassword).text.toString()
            signUp(emailText, passwordText)
        }

        findViewById<Button>(R.id.sign_in_button).setOnClickListener {
            val emailText = findViewById<EditText>(R.id.editTextEmailAddress).text.toString()
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
            if (isChecked) {
                getSharedPreferences("userprofile", Context.MODE_PRIVATE).edit()
                    .putBoolean("darkmode", true).apply()
                AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES)
            } else {
                getSharedPreferences("userprofile", Context.MODE_PRIVATE).edit()
                    .putBoolean("darkmode", false).apply()
                AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO)
            }
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

        findViewById<Button>(R.id.sign_out_button).setOnClickListener {
            signOut()
        }
    }

    private fun initaliseImgButton() {

        findViewById<View>(R.id.businessFavButton).setOnClickListener {
            catergoryButtononCLick(
                findViewById(R.id.businessFavButton),
                "business",
                "fav"
            )
        }
        findViewById<View>(R.id.entertainmentFavButton).setOnClickListener {
            catergoryButtononCLick(
                findViewById(R.id.entertainmentFavButton),
                "entertainment",
                "fav"
            )
        }
        findViewById<View>(R.id.generalFavButton).setOnClickListener {
            catergoryButtononCLick(
                findViewById(R.id.generalFavButton),
                "general",
                "fav"
            )
        }
        findViewById<View>(R.id.healthFavButton).setOnClickListener {
            catergoryButtononCLick(
                findViewById(R.id.healthFavButton),
                "health",
                "fav"
            )
        }
        findViewById<View>(R.id.scienceFavButton).setOnClickListener {
            catergoryButtononCLick(
                findViewById(R.id.scienceFavButton),
                "science",
                "fav"
            )
        }
        findViewById<View>(R.id.sportsFavButton).setOnClickListener {
            catergoryButtononCLick(
                findViewById(R.id.sportsFavButton),
                "sports",
                "fav"
            )
        }
        findViewById<View>(R.id.technologyFavButton).setOnClickListener {
            catergoryButtononCLick(
                findViewById(R.id.technologyFavButton),
                "technology",
                "fav"
            )
        }

        findViewById<View>(R.id.businessFollowButton).setOnClickListener {
            catergoryButtononCLick(
                findViewById(R.id.businessFollowButton),
                "business",
                "fav"
            )
        }

        findViewById<View>(R.id.entertainmentFollowButton).setOnClickListener {
            catergoryButtononCLick(
                findViewById(R.id.entertainmentFollowButton),
                "entertainment",
                "follow"
            )
        }
        findViewById<View>(R.id.generalFollowButton).setOnClickListener {
            catergoryButtononCLick(
                findViewById(R.id.generalFollowButton),
                "general",
                "follow"
            )
        }
        findViewById<View>(R.id.healthFollowButton).setOnClickListener {
            catergoryButtononCLick(
                findViewById(R.id.healthFollowButton),
                "health",
                "follow"
            )
        }
        findViewById<View>(R.id.scienceFollowButton).setOnClickListener {
            catergoryButtononCLick(
                findViewById(R.id.scienceFollowButton),
                "science",
                "follow"
            )
        }
        findViewById<View>(R.id.sportsFollowButton).setOnClickListener {
            catergoryButtononCLick(
                findViewById(R.id.sportsFollowButton),
                "sports",
                "follow"
            )
        }
        findViewById<View>(R.id.technologyFollowButton).setOnClickListener {
            catergoryButtononCLick(
                findViewById(R.id.technologyFollowButton),
                "technology",
                "follow"
            )
        }
    }

    private fun setUp() {
        val userPref = getSharedPreferences("userprofile", Context.MODE_PRIVATE)
        findViewById<SwitchCompat>(R.id.dataSaverSwitch).isChecked =
            userPref.getBoolean("datamode", false)

        findViewById<SwitchCompat>(R.id.darkModeSwitch).isChecked =
            userPref.getBoolean("darkmode", false)

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
        btnLogin.setOnClickListener {
            mAuth = FirebaseAuth.getInstance()
            mAuth.signInWithEmailAndPassword(
                emailText,
                passwordText
            )
                .addOnCompleteListener(
                    this
                ) { task ->
                    if (task.isSuccessful) {
                        mAuth.currentUser
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
                        button()
                    } else {
                        println("Can't login")
                    }
                }
        }


    }

    private fun button() {
        findViewById<AppCompatEditText>(R.id.editTextEmailAddress).setText(
            getSharedPreferences(
                "userprofile",
                0
            ).getString("username", "null")
        )
        findViewById<AppCompatEditText>(R.id.editTextTextPassword).setText(
            getSharedPreferences(
                "userprofile",
                0
            ).getString("password", "null")
        )



        findViewById<AppCompatEditText>(R.id.editTextEmailAddress).isEnabled =
            false
        findViewById<AppCompatEditText>(R.id.editTextTextPassword).isEnabled = false
        findViewById<Button>(R.id.sign_in_button).isEnabled = false
        findViewById<Button>(R.id.sign_up_button).isEnabled = false
        findViewById<Button>(R.id.sign_out_button).isEnabled = true
    }

    private fun signUp(emailText: String, passwordText: String) {

        val btnSignUp = findViewById<Button>(R.id.sign_up_button)
        btnSignUp.setOnClickListener {
            mAuth = FirebaseAuth.getInstance()
            mAuth.createUserWithEmailAndPassword(
                emailText,
                passwordText
            )
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        mAuth.currentUser
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

    private fun signOut() {
        FirebaseAuth.getInstance().signOut()
        findViewById<AppCompatEditText>(R.id.editTextEmailAddress).isEnabled =
            true
        findViewById<AppCompatEditText>(R.id.editTextTextPassword).isEnabled = true
        findViewById<Button>(R.id.sign_in_button).isEnabled = true
        findViewById<Button>(R.id.sign_up_button).isEnabled = true

        findViewById<AppCompatEditText>(R.id.editTextEmailAddress).setText("")
        findViewById<AppCompatEditText>(R.id.editTextTextPassword).setText("")
        FirebaseAuth.getInstance().signOut()
    }

    private fun catergoryButtononCLick(imgButton: ImageButton, category: String, type: String) {
        val sharPref = getSharedPreferences("userprofile", 0)

        val a: Set<String> = HashSet()
        val hold = sharPref.getStringSet(type, a)

        if (type == "fav") {
            if (!hold?.contains(category)!!) {
                imgButton.setImageResource(R.drawable.baseline_favorite_24)
                hold.add(category)
            } else {
                hold.remove(category)
                imgButton.setImageResource(R.drawable.baseline_favorite_border_white_24)
            }
        } else {
            if (!hold?.contains(category)!!) {
                imgButton.setImageResource(R.drawable.baseline_flag_white_24)
                hold.add(category)
            } else {
                hold.remove(category)
                imgButton.setImageResource(R.drawable.baseline_outlined_flag_24)
            }
        }
        sharPref.edit().putStringSet(type, hold).apply()
    }

    private fun setImgButton() {
        setUpImgButton(findViewById(R.id.generalFavButton), "fav", "general")
        setUpImgButton(findViewById(R.id.entertainmentFavButton), "fav", "entertainment")
        setUpImgButton(findViewById(R.id.businessFavButton), "fav", "business")
        setUpImgButton(findViewById(R.id.healthFavButton), "fav", "health")
        setUpImgButton(findViewById(R.id.scienceFavButton), "fav", "science")
        setUpImgButton(findViewById(R.id.technologyFavButton), "fav", "technology")
        setUpImgButton(findViewById(R.id.sportsFavButton), "fav", "sports")

        setUpImgButton(findViewById(R.id.generalFollowButton), "follow", "general")
        setUpImgButton(findViewById(R.id.entertainmentFollowButton), "follow", "entertainment")
        setUpImgButton(findViewById(R.id.businessFollowButton), "follow", "business")
        setUpImgButton(findViewById(R.id.healthFollowButton), "follow", "health")
        setUpImgButton(findViewById(R.id.scienceFollowButton), "follow", "science")
        setUpImgButton(findViewById(R.id.technologyFollowButton), "follow", "technology")
        setUpImgButton(findViewById(R.id.sportsFollowButton), "follow", "sports")

    }

    private fun setUpImgButton(imgButton: ImageButton, type: String, category: String) {
        val sharPref = getSharedPreferences("userprofile", 0)

        val a: Set<String> = HashSet()
        val hold = sharPref.getStringSet(type, a)

        if (type == "fav") {
            if (!hold?.contains(category)!!) {
                imgButton.setImageResource(R.drawable.baseline_favorite_24)
            } else {
                imgButton.setImageResource(R.drawable.baseline_favorite_border_white_24)
            }
        } else {
            if (!hold?.contains(category)!!) {
                imgButton.setImageResource(R.drawable.baseline_flag_white_24)
            } else {
                imgButton.setImageResource(R.drawable.baseline_outlined_flag_24)
            }
        }
    }


    private fun navBar() {
        val bnv: BottomNavigationView =
            findViewById<BottomNavigationView>(R.id.bottomNav)
        val followingIntent = Intent(this, FollowingActivity::class.java)
        val mainActivityIntent = Intent(this, MainActivity::class.java)
        val settingActivityIntent = Intent(this, SettingsActivity::class.java)

        bnv.selectedItemId = R.id.settingItem

        bnv.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.favItem -> startActivity(followingIntent)
                R.id.followItem -> startActivity(followingIntent)
                R.id.worldItem -> startActivity(mainActivityIntent)
                R.id.settingItem -> startActivity(settingActivityIntent)

            }
            true
        }
    }
}