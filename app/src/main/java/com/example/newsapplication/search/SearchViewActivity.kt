package com.example.newsapplication.search

import android.net.Uri
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapplication.R
import com.example.newsapplication.main.MainActivity

class SearchViewActivity : MainActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<RecyclerView>(R.id.recyclerView).layoutManager = LinearLayoutManager(this)
        getNews()
        navBar()
    }

    override fun URLBuilder(): String {
        val builder = Uri.Builder()
        builder.scheme("https")
            .authority("newsapi.org")
            .appendPath("v2")
            .appendPath("everything")
            .appendQueryParameter("q", intent.getStringExtra("query"))
            .appendQueryParameter("sortBy", "publishedAt")
            .appendQueryParameter("apiKey", "cb2d036fd31f441da320db9ffcf548a5")

        println(builder.build().toString())
        return builder.build().toString()
    }
}