package com.example.newsapplication.main

import android.content.Context
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


class MainAdapter(private val articles: Articles, private val dataMode: Boolean) :
    RecyclerView.Adapter<MainAdapter.CustomViewHolder>() {


    override fun getItemCount(): Int {
        return articles.articles.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        //create View
        val layoutInflater = LayoutInflater.from(parent?.context)
        val newsCard = layoutInflater.inflate(R.layout.card_view, parent, false)

        return CustomViewHolder(newsCard)
    }

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


