package com.example.kmmnews.core.data.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import com.example.kmmnews.database.NewsArticle as LocalNewsArticle

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
    val source: Source = Source(),
    @SerialName("author")
    val author: String = "",
    @SerialName("title")
    val title: String = "",
    @SerialName("description")
    val description: String = "",
    @SerialName("url")
    val url: String = "",
    @SerialName("urlToImage")
    val urlToImage: String = "",
    @SerialName("publishedAt")
    val publishedAt: String = "", // ISO8061
    @SerialName("content")
    val content: String = "",

    ) {
    @Serializable
    data class Source(
        @SerialName("id")
        val id: String = "",
        @SerialName("name")
        val name: String = "",
    )
}

fun NewsArticle.Source.toMap() = mapOf("id" to this.id, "name" to this.name)

fun NewsArticle.toLocalNewsArticle() =
    LocalNewsArticle(
        _id = 0,
        author = this.author,
        content = this.content,
        description = this
            .description,
        publishedAt = this.publishedAt,
        sources = this.source.toMap(),
        title = this.title,
        url = this.url,
        urlToImage = this.urlToImage
    )

fun LocalNewsArticle.toNewsArticle() = NewsArticle(
    source = NewsArticle.Source(id = this.sources["id"] ?: "", name = this.sources["name"] ?: ""),
    author = this.author,
    title = this.title,
    description = this.description,
    url = this.url,
    urlToImage = this.urlToImage,
    publishedAt = this.publishedAt,
    content = this.content,
)

fun List<NewsArticle>.toLocalNewsArticles() = map(NewsArticle::toLocalNewsArticle)