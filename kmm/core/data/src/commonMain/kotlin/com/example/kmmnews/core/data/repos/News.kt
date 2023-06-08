package com.example.kmmnews.core.data.repos

import com.example.kmmnews.core.data.dtos.ApiResponse
import com.example.kmmnews.core.data.dtos.NewsArticle
import com.example.kmmnews.core.data.services.NewsApiService
import com.example.kmmnews.core.data.utils.safeApiCall
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

interface News {
    suspend fun getNewForCountry(countryName: String): Flow<ApiResponse<List<NewsArticle>>>
}

internal class NewsImpl(
    private val newsApiService: NewsApiService,
    private val ioDispatcher: CoroutineDispatcher,
    private val coroutineScope: CoroutineScope
) : News {
    override suspend fun getNewForCountry(countryName: String): Flow<ApiResponse<List<NewsArticle>>> {
        return safeApiCall {
            newsApiService.getNationalNews(countryName).articles
        }.flowOn(ioDispatcher)
    }
}