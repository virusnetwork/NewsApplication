package com.example.newsapplication.main

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapplication.LowDataActivity
import com.example.newsapplication.R
import com.example.newsapplication.following.FollowingActivity
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
    TODO fix buttons
    TODO refrences
 */

open class MainActivity : AppCompatActivity() {

    private lateinit var articles: Articles

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<RecyclerView>(R.id.recyclerView).layoutManager = LinearLayoutManager(this)
        getNews()
        navBar()

    }

    open fun navBar() {
        val bnv: BottomNavigationView =
            findViewById<BottomNavigationView>(R.id.bottomNav) as BottomNavigationView
        val followingIntent = Intent(this, FollowingActivity::class.java)
        val mainActivityIntent = Intent(this, MainActivity::class.java)
        val settingActivityIntent = Intent(this, SettingsAcitvity::class.java)

        bnv.selectedItemId = R.id.worldItem

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

    open fun URLBuilder(): String {
        val builder = Uri.Builder()
        builder.scheme("https")
            .authority("newsapi.org")
            .appendPath("v2")
            .appendPath("top-headlines")
            .appendQueryParameter("country", countryGetter())
            .appendQueryParameter("apiKey", "cb2d036fd31f441da320db9ffcf548a5")
        return builder.build().toString()
    }

    fun countryGetter(): String {
        return when (getSharedPreferences("userprofile", 0).getInt("country", 0)) {
            0 -> "GB"
            1 -> "US"
            2 -> "CA"
            3 -> "FR"
            4 -> "IE"
            5 -> "GR"
            else -> "GB"
        }

    }

    fun getNews() {
        val newsRequest = Request.Builder()
            .url(URLBuilder())
            .build()
        val client = OkHttpClient()

        client.newCall(newsRequest).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                println(e.message)
            }

            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string()

                val gson = GsonBuilder().create()
                articles = gson.fromJson(body, Articles::class.java)

                runOnUiThread {
                    initialseRecylerViewAdapter(articles)
                    println(URLBuilder())
                }
            }
        })
    }

    fun goToURL(view: View) {

        if (getSharedPreferences("userprofile", 0).getBoolean("datamode", false)) {
            startActivity(
                Intent(this, LowDataActivity::class.java).putExtra(
                    "content",
                    view.findViewById<TextView>(R.id.articleContent).text.toString()
                )
            )
        } else {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(view.findViewById<TextView>(R.id.URL).text.toString())
                )
            )
        }


    }

    fun initialseRecylerViewAdapter(articles: Articles) {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = MainAdapter(
            articles,
            getSharedPreferences("userprofile", Context.MODE_PRIVATE).getBoolean(
                "datamode",
                false
            )
        )

    }

}

