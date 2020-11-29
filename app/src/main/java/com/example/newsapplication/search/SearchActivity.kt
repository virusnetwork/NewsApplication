package com.example.newsapplication.search

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.newsapplication.R

class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_seach)
        findViewById<View>(R.id.searchButton).setOnClickListener {
            val text = findViewById<EditText>(R.id.searchText).text.toString()

            startActivity(Intent(this, SearchViewActivity::class.java).putExtra("query", text))
        }
    }


}