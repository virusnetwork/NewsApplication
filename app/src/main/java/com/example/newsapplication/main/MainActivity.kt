package com.example.newsapplication.main

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapplication.R
import com.example.newsapplication.followingActivity
import com.example.newsapplication.models.Articles
import com.example.newsapplication.settings.SettingsAcitvity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.gson.GsonBuilder
import okhttp3.*
import java.io.IOException

/*
    TODO change publisher to source
    TODO implement faviortes
    TODO implement following
    TODO implement search features
 */

class MainActivity : AppCompatActivity() {

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

    private fun URLBuilder(): String {
        val builder = Uri.Builder()
        builder.scheme("https")
            .authority("newsapi.org")
            .appendPath("v2")
            .appendPath("top-headlines")
            .appendQueryParameter("country", "us")
            .appendQueryParameter("apiKey", "cb2d036fd31f441da320db9ffcf548a5")
        return builder.build().toString()
    }


    private fun getNews() {
        val country = "country=us"
        val url = "http://newsapi.org/v2/top-headlines?country=us&apiKey=cb2d036fd31f441da320db9ffcf548a5"
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

    fun goToURL(view:View){
       var website = Uri.parse(view.findViewById<TextView>(R.id.URL).text.toString())
       var webIntent = Intent(Intent.ACTION_VIEW,website)
        startActivity(webIntent)


    }

    private fun initialseRecylerViewAdapter(articles: Articles) {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = mainAdapter(articles)

    }

}

