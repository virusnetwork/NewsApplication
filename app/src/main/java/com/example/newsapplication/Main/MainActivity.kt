package com.example.newsapplication.Main

import android.content.ClipData
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapplication.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.gson.GsonBuilder
import okhttp3.*
import java.io.IOException

/*
    TODO implement go to url
    TODO change publisher to source
    TODO implement setting window
    TODO implement firebase
    TODO implement faviortes
    TODO implement following
    TODO allow search features
 */

class MainActivity : AppCompatActivity() {

    private lateinit var articles: Articles

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //getNews()
        articles = GsonBuilder().create().fromJson(testData, Articles::class.java)
        initialseRecylerViewAdapter()
        navBar()

    }


    private fun navBar() {
        val bnv: BottomNavigationView =
            findViewById<BottomNavigationView>(R.id.bottomNav) as BottomNavigationView
        val followingIntent = Intent(this,followingActivity::class.java)
        val mainActivityIntent = Intent(this,MainActivity::class.java)
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


    private fun getNews() {
        val url =
            "http://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=cb2d036fd31f441da320db9ffcf548a5"
        val newsRequest = Request.Builder()
            .url(url)
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
            }
        })
    }

    private fun initialseRecylerViewAdapter() {
        //TODO implement wait for other thread to finish
        findViewById<RecyclerView>(R.id.recyclerView).adapter = mainAdapter(articles)
        findViewById<RecyclerView>(R.id.recyclerView).layoutManager = LinearLayoutManager(this)
    }
}

class Articles(val status: String, val totalResults: Int, val articles: Array<Article>)