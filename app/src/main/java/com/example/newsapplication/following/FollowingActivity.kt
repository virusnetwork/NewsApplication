package com.example.newsapplication.following

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapplication.R
import com.example.newsapplication.main.MainActivity
import com.example.newsapplication.models.Articles
import com.example.newsapplication.settings.SettingsAcitvity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.gson.GsonBuilder
import okhttp3.*
import java.io.IOException

class FollowingActivity : MainActivity() {

    private lateinit var articles: Articles

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<RecyclerView>(R.id.recyclerView).layoutManager = LinearLayoutManager(this)
        getNews()
        navBar()

    }

    private fun navBar() {
        val bnv: BottomNavigationView =
            findViewById<BottomNavigationView>(R.id.bottomNav) as BottomNavigationView
        val followingIntent = Intent(this, FollowingActivity::class.java)
        val mainActivityIntent = Intent(this, MainActivity::class.java)
        val settingActivityIntent = Intent(this, SettingsAcitvity::class.java)

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

    private fun URLBuilder(): String {
        val builder = Uri.Builder()
        val a: Set<String> = setOf("")
        val b = getSharedPreferences("userprofile", 0).getStringSet("follow", a)
        builder.scheme("https")
            .authority("newsapi.org")
            .appendPath("v2")
            .appendPath("top-headlines")
            .appendQueryParameter("country", countryGetter())
        b?.iterator()?.forEach { t ->
            builder.appendQueryParameter("category", t)
        }
        builder.appendQueryParameter("apiKey", "cb2d036fd31f441da320db9ffcf548a5")

        println(builder.build().toString())
        return builder.build().toString()
    }


    private fun getNews() {
        val newsRequest = Request.Builder()
            .url(URLBuilder())
            .build()
        val client = OkHttpClient()

        client.newCall(newsRequest).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                println(e.message)
            }

            override fun onResponse(call: Call, response: Response) {
                val body = response?.body?.string()

                val gson = GsonBuilder().create()
                articles = gson.fromJson(body, Articles::class.java)

                runOnUiThread {
                    initialseRecylerViewAdapter(articles)
                    println(URLBuilder())
                }
            }
        })
    }

}
