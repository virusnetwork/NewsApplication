package com.example.newsapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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

    private lateinit var articles:Articles

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //getNews()
        articles = GsonBuilder().create().fromJson(testData,Articles::class.java)
        initialseRecylerViewAdapter()

    }

    private fun getNews() {
        val url = "http://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=cb2d036fd31f441da320db9ffcf548a5"
        val newsRequest = Request.Builder()
            .url(url)
            .build()
        val client = OkHttpClient()
        client.newCall(newsRequest).enqueue(object: Callback {
            override fun onFailure(call: Call, e: IOException) {
                println(e.message)
            }

            override fun onResponse(call: Call, response: Response) {
                val body = response?.body?.string()

                val gson = GsonBuilder().create()
                articles = gson.fromJson(body,Articles::class.java)
            }
        })
    }

    private fun initialseRecylerViewAdapter()
    {
        //TODO implement wait for other thread to finish
        findViewById<RecyclerView>(R.id.recyclerView).adapter=mainAdapter(articles)
        findViewById<RecyclerView>(R.id.recyclerView).layoutManager = LinearLayoutManager(this)
    }
}

class Articles(val status: String, val totalResults : Int, val articles : Array<Article> )