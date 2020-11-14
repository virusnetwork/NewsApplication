package com.example.newsapplication.models

data class Articles(
    val status: String,
    val totalResults: Int,
    val articles: Array<Article>
)