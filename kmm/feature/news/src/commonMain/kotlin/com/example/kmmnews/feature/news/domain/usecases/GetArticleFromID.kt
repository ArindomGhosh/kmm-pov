package com.example.kmmnews.feature.news.domain.usecases

import com.example.kmmnews.core.data.repos.News
import com.example.kmmnews.feature.news.domain.entities.Article
import com.example.kmmnews.feature.news.domain.entities.toArticle

class GetArticleFromID(
    private val news: News,
) {
    suspend operator fun invoke(articleID: Long): Article {
        return news.getNewsArticleForId(articleID).toArticle()
    }
}