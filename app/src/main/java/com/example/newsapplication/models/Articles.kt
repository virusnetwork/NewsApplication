package com.example.newsapplication.models

/**
 * Data class for an array of articles gotten from NewsAPI
 * @property status String
 * @property totalResults Int
 * @property articles Array<Article>
 * @constructor
 *
 * @author Miles Singleton (954581)
 */
data class Articles(
    val status: String,
    val totalResults: Int,
    val articles: Array<Article>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Articles

        if (status != other.status) return false
        if (totalResults != other.totalResults) return false
        if (!articles.contentEquals(other.articles)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = status.hashCode()
        result = 31 * result + totalResults
        result = 31 * result + articles.contentHashCode()
        return result
    }
}