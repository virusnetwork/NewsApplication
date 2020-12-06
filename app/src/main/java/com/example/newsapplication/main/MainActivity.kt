package com.example.newsapplication.main

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapplication.R
import com.example.newsapplication.favorite.FavouriteActivity
import com.example.newsapplication.following.FollowingActivity
import com.example.newsapplication.lowdata.LowDataActivity
import com.example.newsapplication.models.Articles
import com.example.newsapplication.search.SearchActivity
import com.example.newsapplication.settings.SettingsActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.gson.GsonBuilder
import okhttp3.*
import java.io.IOException

/**
 * CLass for drawing all-headlines (main) activity
 *
 * @property articles Articles
 * @author Miles Singleton (954581)
 */
open class MainActivity : AppCompatActivity() {

    private lateinit var articles: Articles

    /**
     * Creates main activity
     *
     * @param savedInstanceState Bundle?
     */
    override fun onCreate(savedInstanceState: Bundle?) {

        if (getSharedPreferences(
                FirebaseAuth.getInstance().currentUser.toString(),
                0
            ).getBoolean("darkmode", false)
        ) {
            AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES)
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<RecyclerView>(R.id.recyclerView).layoutManager = LinearLayoutManager(this)
        getNews()
        navBar()
        search()

    }

    /**
     * sets on-click for the search button
     */
    private fun search() {
        val search: View = findViewById(R.id.searchButton)
        search.setOnClickListener {
            startActivity(Intent(this, SearchActivity::class.java))

        }
    }

    /**
     * Sets up nav bar
     */
    open fun navBar() {
        val bnv: BottomNavigationView =
            findViewById<BottomNavigationView>(R.id.bottomNav) as BottomNavigationView
        val followingIntent = Intent(this, FollowingActivity::class.java)
        val mainActivityIntent = Intent(this, MainActivity::class.java)
        val favouriteIntent = Intent(this, FavouriteActivity::class.java)
        val settingActivityIntent = Intent(this, SettingsActivity::class.java)

        bnv.selectedItemId = R.id.worldItem

        bnv.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.favItem -> startActivity(favouriteIntent)
                R.id.followItem -> startActivity(followingIntent)
                R.id.worldItem -> startActivity(mainActivityIntent)
                R.id.settingItem -> startActivity(settingActivityIntent)

            }
            true
        }
    }

    /**
     * Builds URL for finding all headlines
     *
     * @return The URL for receiving news articles
     */
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

    /**
     * Sets up the country to use in URL builder
     *
     * @return two character country code
     */
    fun countryGetter(): String {
        return when (getSharedPreferences(
            FirebaseAuth.getInstance().currentUser.toString(),
            0
        ).getInt("country", 0)) {
            0 -> "GB"
            1 -> "US"
            2 -> "CA"
            3 -> "FR"
            4 -> "IE"
            5 -> "GR"
            else -> "GB"
        }

    }

    /**
     * Gets all news articles from URL builder,
     * then fills the articles property with news articles
     */
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
                }
            }
        })
    }

    /**
     * Used to go open web browser with user selected news article
     *
     * @param view the news card the user has selected
     */
    fun goToURL(view: View) {

        if (getSharedPreferences(
                FirebaseAuth.getInstance().currentUser.toString(),
                0
            ).getBoolean("datamode", false)
        ) {
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

    /**
     * Sets up news cards to display all articles in articles
     *
     * @param articles Articles
     */
    fun initialseRecylerViewAdapter(articles: Articles) {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = MainAdapter(
            articles,
            getSharedPreferences(
                FirebaseAuth.getInstance().currentUser.toString(),
                Context.MODE_PRIVATE
            ).getBoolean(
                "datamode",
                false
            )
        )

    }

}

