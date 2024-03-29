package com.example.newsapplication.following

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapplication.R
import com.example.newsapplication.favorite.FavouriteActivity
import com.example.newsapplication.main.MainActivity
import com.example.newsapplication.settings.SettingsActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth

/**
 * Creates the following acitivty
 *
 * @author Miles Singleton (954581)
 */
class FollowingActivity : MainActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<RecyclerView>(R.id.recyclerView).layoutManager = LinearLayoutManager(this)
        getNews()
        navBar()
    }

    /**
     * Sets up the nav bar
     */
    override fun navBar() {
        val bnv: BottomNavigationView =
            findViewById<BottomNavigationView>(R.id.bottomNav) as BottomNavigationView
        val followingIntent = Intent(this, FollowingActivity::class.java)
        val mainActivityIntent = Intent(this, MainActivity::class.java)
        val favouriteIntent = Intent(this, FavouriteActivity::class.java)
        val settingActivityIntent = Intent(this, SettingsActivity::class.java)

        bnv.selectedItemId = R.id.followItem
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
     * Builds the web address for getting news articles of users following categories
     *
     * @return String
     */
    override fun URLBuilder(): String {
        val builder = Uri.Builder()
        val category = setOf<String>(
            "general",
            "entertainment",
            "business",
            "health",
            "science",
            "technology",
            "sports"
        )

        val b = mutableSetOf<String>()
        for (cat in category) {
            (if (getSharedPreferences(
                    FirebaseAuth.getInstance().currentUser?.email.toString(),
                    0
                ).getBoolean("follow$cat", false)
            ) {
                b.add(cat)
            })

        }
        builder.scheme("https")
            .authority("newsapi.org")
            .appendPath("v2")
            .appendPath("top-headlines")
            .appendQueryParameter("country", countryGetter())
        b.iterator().forEach { t ->
            builder.appendQueryParameter("category", t)
        }
        builder.appendQueryParameter("apiKey", "cb2d036fd31f441da320db9ffcf548a5")

        return builder.build().toString()
    }

}
