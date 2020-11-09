package com.example.newsapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class mainAdapter(val articles:Articles): RecyclerView.Adapter<mainAdapter.customViewHolder>() {


    override fun getItemCount(): Int {
      return articles.articles.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): customViewHolder {
        //create View
        val layoutInflater = LayoutInflater.from(parent?.context)
        val newsCard = layoutInflater.inflate(R.layout.card_view,parent, false)

        return customViewHolder(newsCard)
    }

    override fun onBindViewHolder(holder: customViewHolder, position: Int) {
        val article = articles.articles[position]
        holder.descriptionTextView.text = article.description
        holder.publisherTextView.text = article.source.name
        holder.titleTextView.text=article.title

    }

    inner class customViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
        var titleTextView =itemView.findViewById<TextView>(R.id.textView_Title) as TextView
        var descriptionTextView =itemView.findViewById<TextView>(R.id.textView_description) as TextView
        var publisherTextView =itemView.findViewById<TextView>(R.id.textView_Publisher) as TextView

}

}

