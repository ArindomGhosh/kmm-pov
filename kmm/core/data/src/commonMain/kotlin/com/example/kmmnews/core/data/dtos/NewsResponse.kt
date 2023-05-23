package com.example.kmmnews.core.data.dtos

data class NewsResponse(
    val status:String,
    val topResults:Int,
    val articles:List<NewsArticle>
)

data class NewsArticle(
    val source: Source,
    val author:String,
    val title:String,
    val description:String,
    val urlToImage:String,
    val publishedAt:String, // ISO8061
    val content:String,

){
    data class Source(
        val id:String?=null,
        val name:String
    )
}

