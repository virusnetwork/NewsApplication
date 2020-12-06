package com.example.newsapplication.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapplication.R
import com.example.newsapplication.models.Articles
import com.squareup.picasso.Picasso


/**
 * Adapter for turning news articles in news cards
 *
 * @property articles Articles
 * @property dataMode Boolean
 * @constructor
 *
 * @author Miles Singleton (954581)
 */
class MainAdapter(private val articles: Articles, private val dataMode: Boolean) :
    RecyclerView.Adapter<MainAdapter.CustomViewHolder>() {


    /**
     * @return number of news articles
     */
    override fun getItemCount(): Int {
        return articles.articles.size
    }

    /**
     * creates and returns view holder for a news card
     *
     * @param parent ViewGroup
     * @param viewType Int
     * @return CustomViewHolder
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val newsCard = layoutInflater.inflate(R.layout.card_view, parent, false)

        return CustomViewHolder(newsCard)
    }

    /**
     * Sets up news card and all its properties
     *
     * @param holder CustomViewHolder
     * @param position Int
     */
    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val article = articles.articles[position]
        holder.descriptionTextView.text = article.description
        holder.publisherTextView.text = article.source.name
        holder.titleTextView.text = article.title
        holder.URLTextVIew.text = article.url
        holder.articleContent.text = article.content
        if (dataMode) {
            holder.articleImageView.isVisible = false
        } else {
            Picasso.get().load(article.urlToImage).into(holder.articleImageView)
        }


    }


    /**
     *  Sets up custom view holder,
     *  What each news card needs changing for
     *  e.g., setting up news card title etc.
     * @property itemView View
     * @property titleTextView TextView
     * @property descriptionTextView TextView
     * @property publisherTextView TextView
     * @property URLTextVIew TextView
     * @property articleImageView ImageView
     * @property articleContent TextView
     * @constructor
     */
    inner class CustomViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
        var titleTextView = itemView.findViewById(R.id.textView_Title) as TextView
        var descriptionTextView =
            itemView.findViewById(R.id.textView_description) as TextView
        var publisherTextView = itemView.findViewById(R.id.textView_Publisher) as TextView
        var URLTextVIew = itemView.findViewById(R.id.URL) as TextView
        var articleImageView = itemView.findViewById(R.id.articleImageView) as ImageView
        var articleContent = itemView.findViewById(R.id.articleContent) as TextView
    }
}


