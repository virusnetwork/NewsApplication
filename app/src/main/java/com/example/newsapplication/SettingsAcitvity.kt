package com.example.newsapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.newsapplication.Main.MainActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth


class SettingsAcitvity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.setting_windows)
        mAuth = FirebaseAuth.getInstance()
        navBar()

        val emailText = findViewById<EditText>(R.id.editTextTextEmailAddress)
        val passwordText = findViewById<EditText>(R.id.editTextTextPassword)

        val btnLogin = findViewById<Button>(R.id.sign_in_button)
        btnLogin.setOnClickListener { view ->
            mAuth = FirebaseAuth.getInstance()
            mAuth.signInWithEmailAndPassword(
                emailText.text.toString(),
                passwordText.text.toString()
            )
                .addOnCompleteListener(
                    this
                ) { task ->
                    if (task.isSuccessful) {
                        val user = mAuth.currentUser
                    } else {
                        println("Can't login")
                    }
                }
        }

        val btnSignUp = findViewById<Button>(R.id.sign_up_button)
        btnSignUp.setOnClickListener { view ->
            mAuth = FirebaseAuth.getInstance()
            mAuth.createUserWithEmailAndPassword(
                emailText.text.toString(),
                passwordText.text.toString()
            )
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        val user = mAuth.currentUser
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