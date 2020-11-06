package com.example.newsapplication.news_api

import com.example.newsapplication.ArticleClasses.TopHeadlines
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface TopHeadlinesEndPoint {

    @GET("top-headlines")
    fun getTopHeadlines(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String
    ): Observable<TopHeadlines>

    @GET("top-headlines")
    fun getUserSearchInput(
        @Query("apiKey") apiKey: String,
        @Query("q") q: String
    ): Observable<TopHeadlines>
}