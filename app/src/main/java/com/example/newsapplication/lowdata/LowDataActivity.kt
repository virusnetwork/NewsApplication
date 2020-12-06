package com.example.newsapplication.lowdata

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.newsapplication.R

/**
 * Shows the articles content only,
 * works but needs a premium version of NewsAPI which is at $449 for a month
 *
 * @author Miles Singleton (954581)
 */
class LowDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.low_data_reader)

        //!! requires paid version of newAPI to get the contents of the article
        findViewById<TextView>(R.id.lowdataText).text = intent.getStringExtra("content")
    }
}