package com.example.newsapplication.favorite

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapplication.R
import com.example.newsapplication.models.Articles
import com.squareup.picasso.Picasso

class FavouriteAdapter(private val articles: Articles) :
    RecyclerView.Adapter<FavouriteAdapter.CustomViewHolder>() {

    override fun getItemCount(): Int {
        return articles.articles.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        //create View
        val layoutInflater = LayoutInflater.from(parent.context)
        val newsCard = layoutInflater.inflate(R.layout.card_view, parent, false)

        return CustomViewHolder(newsCard)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val article = articles.articles[position]
        holder.descriptionTextView.text = article.description
        holder.publisherTextView.text = article.source.name
        holder.titleTextView.text = article.title
        holder.URLTextVIew.text = article.url
        Picasso.get().load(article.urlToImage).into(holder.articleImageView)


    }


    inner class CustomViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
        var titleTextView = itemView.findViewById(R.id.textView_Title) as TextView
        var descriptionTextView =
            itemView.findViewById(R.id.textView_description) as TextView
        var publisherTextView = itemView.findViewById(R.id.textView_Publisher) as TextView
        var URLTextVIew = itemView.findViewById(R.id.URL) as TextView
        var articleImageView = itemView.findViewById(R.id.articleImageView) as ImageView


    }
}