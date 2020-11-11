package com.example.newsapplication

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.newsapplication.Main.MainActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class settingsAdapter : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.setting_windows)
        navBar()


    }

    private fun navBar() {
        val bnv: BottomNavigationView =
            findViewById<BottomNavigationView>(R.id.bottomNav) as BottomNavigationView
        val followingIntent = Intent(this,followingActivity::class.java)
        val mainActivityIntent = Intent(this, MainActivity::class.java)
        val settingActivityIntent = Intent(this,settingsAdapter::class.java)

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