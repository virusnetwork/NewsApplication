package com.example.newsapplication.search

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.newsapplication.R

/**
 * Sets up search activity
 * activity for entering user's search query
 *
 * @author Miles Singleton (954581)
 */
class SearchActivity : AppCompatActivity() {

    /**
     * creates view for entering user search query
     *
     * @param savedInstanceState Bundle?
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_seach)
        findViewById<View>(R.id.searchButton).setOnClickListener {
            val text = findViewById<EditText>(R.id.searchText).text.toString()

            startActivity(Intent(this, SearchViewActivity::class.java).putExtra("query", text))
        }
    }


}