package com.example.newsapplication

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.GsonBuilder
import okhttp3.*
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException
import java.util.*


class MainActivity : AppCompatActivity() {

    private val articleList = ArrayList<Article>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getNews()
    }

    fun getNews() {
        val url = "http://newsapi.org/v2/top-headlines?country=uk&apiKey=cb2d036fd31f441da320db9ffcf548a5"
        val newsRequest = Request.Builder()
            .url(url)
            .build()
        val client = OkHttpClient()
        client.newCall(newsRequest).enqueue(object: Callback {
            override fun onFailure(call: Call, e: IOException) {
                TODO("Not yet implemented")
                println("Failed")
            }

            override fun onResponse(call: Call, response: Response) {
                val body = response?.body?.string()

                val gson = GsonBuilder().create()
                val help = gson.fromJson(testData,hold::class.java)
            }

        })
    }

    fun getJsonDataFromAsset(context: Context, fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }


    private fun processesNews(rawNewsData : String) {
        val newsJSON = JSONArray(rawNewsData)

        newsJSON.getJSONArray(0)

    }
}

class hold(val status: String, val totalResult : Int, val articles : List<Article> )