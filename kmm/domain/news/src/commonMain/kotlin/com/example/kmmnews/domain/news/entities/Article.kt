package com.example.kmmnews.domain.news.entities

import com.example.kmmnews.core.data.dtos.NewsArticle
import kotlinx.serialization.Serializable

@Serializable
data class Article(
    val articleId:Long,
    val title: String,
    val description: String,
    val imageUrl: String,
    val publishedAt: String,  // iso8061
    val content: String,
    val source: String,
)

fun NewsArticle.toArticle() =
    Article(
        articleId = this.id,
        title = this.title,
        description = this.description,
        imageUrl = this.urlToImage,
        publishedAt = this.publishedAt,
        content = this.content,
        source = this.source.name
    )

fun List<NewsArticle>.toArticles() = map {
    it.toArticle()
}