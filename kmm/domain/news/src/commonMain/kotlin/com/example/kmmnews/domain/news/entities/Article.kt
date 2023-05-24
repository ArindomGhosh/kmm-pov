package com.example.kmmnews.domain.news.entities

import com.example.kmmnews.core.data.dtos.NewsArticle

data class Article(
    val title:String,
    val description:String,
    val imageUrl:String,
    val publishedAt:String,  // iso8061
    val content:String,
    val source:String,
)

fun NewsArticle.toArticle()=
    Article(
        title=this.title,
        description=this.description,
        imageUrl = this.urlToImage,
        publishedAt=this.publishedAt,
        content=this.content,
        source=this.source.name
    )