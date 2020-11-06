package com.example.newsapplication.ArticleClasses

data class TopHeadlines(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
)