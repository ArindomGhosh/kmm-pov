package com.example.kmmnews.core.data.repos

import com.example.kmmnews.core.data.dtos.ApiResponse
import com.example.kmmnews.core.data.dtos.NewsArticle
import com.example.kmmnews.core.data.services.NewsApiService
import com.example.kmmnews.core.data.utils.safeApiCall
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface News {
    suspend fun getNewForCountry(countryName: String): Flow<ApiResponse<List<NewsArticle>>>
}

class NewsImpl(
    private val newsApiService: NewsApiService
) : News {
    override suspend fun getNewForCountry(countryName: String): Flow<ApiResponse<List<NewsArticle>>> {
        return safeApiCall {
               newsApiService.getNationalNews(countryName).articles
        }
    }
}