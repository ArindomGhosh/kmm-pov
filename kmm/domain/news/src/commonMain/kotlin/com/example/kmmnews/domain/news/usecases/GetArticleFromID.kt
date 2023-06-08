package com.example.kmmnews.domain.news.usecases

import com.example.kmmnews.core.data.repos.News
import com.example.kmmnews.domain.news.entities.Article
import com.example.kmmnews.domain.news.entities.toArticle

class GetArticleFromID(
    private val news: News,
) {
    suspend operator fun invoke(articleID: Long): Article {
        return news.getNewsArticleForId(articleID).toArticle()
    }
}