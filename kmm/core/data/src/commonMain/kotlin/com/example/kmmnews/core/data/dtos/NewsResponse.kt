package com.example.kmmnews.core.data.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NewsResponse(
    @SerialName("status")
    val status: String,
    @SerialName("totalResults")
    val topResults: Int,
    @SerialName("articles")
    val articles: List<NewsArticle>,
)

@Serializable
data class NewsArticle(
    @SerialName("source")
    val source: Source,
    @SerialName("author")
    val author: String,
    @SerialName("title")
    val title: String,
    @SerialName("description")
    val description: String,
    @SerialName("url")
    val url: String,
    @SerialName("urlToImage")
    val urlToImage: String,
    @SerialName("publishedAt")
    val publishedAt: String, // ISO8061
    @SerialName("content")
    val content: String,

) {
    @Serializable
    data class Source(
        @SerialName("id")
        val id: String? = null,
        @SerialName("name")
        val name: String,
    )
}
