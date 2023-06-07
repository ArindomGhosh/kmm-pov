package com.example.kmmnews.core.data.dtos

import com.example.kmmnews.core.database.NewsArticle as LocalNewsArticle

data class NewsArticle(
    val id: Long = 0L,
    val source: Source = Source(),
    val author: String = "",
    val title: String = "",
    val description: String = "",
    val url: String = "",
    val urlToImage: String = "",
    val publishedAt: String = "", // ISO8061
    val content: String = "",
) {
    data class Source(
        val id: String = "",
        val name: String = "",
    )
}

fun LocalNewsArticle.toNewsArticle() = NewsArticle(
    id = this._id,
    source = NewsArticle.Source(id = this.sources["id"] ?: "", name = this.sources["name"] ?: ""),
    author = this.author,
    title = this.title,
    description = this.description,
    url = this.url,
    urlToImage = this.urlToImage,
    publishedAt = this.publishedAt,
    content = this.content,
)

fun List<LocalNewsArticle>.toNewsArticles() = map(LocalNewsArticle::toNewsArticle)