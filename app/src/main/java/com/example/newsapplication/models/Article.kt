package com.example.newsapplication.models

/**
 * Data class for a article
 * @property source Source
 * @property author String
 * @property title String
 * @property description String
 * @property url String
 * @property urlToImage String
 * @property publishedAt String
 * @property content String
 * @constructor
 *
 * @author Miles Singleton (954581)
 */
data class Article(
    val source: Source,
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String
)