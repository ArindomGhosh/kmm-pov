package com.example.kmmnews.domain.news.usecases

import com.example.kmmnews.core.data.dtos.ApiException
import com.example.kmmnews.core.data.dtos.ApiResponse
import com.example.kmmnews.core.data.dtos.NewsArticle
import com.example.kmmnews.core.data.repos.News
import com.example.kmmnews.domain.common.entities.Entity
import com.example.kmmnews.domain.common.utils.mapToEntity
import com.example.kmmnews.domain.news.entities.Article
import com.example.kmmnews.domain.news.entities.toArticles
import kotlinx.coroutines.flow.Flow

class GetNationalNews(
    private val news: News,
) {
    suspend operator fun invoke(country: String): Flow<Entity<List<Article>>> {
        return news.getNewForCountry(country)
            .mapToEntity(List<NewsArticle>::toArticles)
    }
}
