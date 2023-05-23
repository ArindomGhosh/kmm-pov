package com.example.kmmnews.feature.news.models

//todo : Delete this and use the Entity from Domain Layer
data class NewsArticle(
    val title: String,
    val imageUrl: String,
    val description: String
)