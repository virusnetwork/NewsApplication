package com.example.newsapplication

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.newsapplication.following.FollowingActivity
import com.example.newsapplication.main.MainActivity
import com.example.newsapplication.settings.SettingsAcitvity
import com.google.android.material.bottomnavigation.BottomNavigationView

class LowDataActivity :  AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.low_data_reader)

        //! rqeuires paid version of newAPI to get the contents of the article
        findViewById<TextView>(R.id.lowdataText).text = intent.getStringExtra("content")
    }
}