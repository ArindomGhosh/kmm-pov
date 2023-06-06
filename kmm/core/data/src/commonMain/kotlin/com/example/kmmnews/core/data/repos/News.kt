package com.example.kmmnews.core.data.repos

import com.example.kmmnews.core.data.dtos.ApiResponse
import com.example.kmmnews.core.data.dtos.NewsArticle
import com.example.kmmnews.core.data.dtos.toLocalNewsArticles
import com.example.kmmnews.core.data.dtos.toNewsArticle
import com.example.kmmnews.core.data.services.NewsApiService
import com.example.kmmnews.core.data.utils.safeApiCall
import com.example.kmmnews.database.KmmNewsArticlesDao
import com.example.kmmnews.database.KmmNewsDataBase
import com.example.kmmnews.database.NewsArticleQueries
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

interface News {
    suspend fun getNewForCountry(countryName: String): Flow<ApiResponse<List<NewsArticle>>>

    suspend fun getNewsArticleForId(id:Long):NewsArticle
}

class NewsImpl(
    private val newsApiService: NewsApiService,
    private val kmmNewsArticlesDao: KmmNewsArticlesDao,
    private val ioDispatcher: CoroutineDispatcher,
    private val coroutineScope: CoroutineScope
) : News {
    override suspend fun getNewForCountry(countryName: String): Flow<ApiResponse<List<NewsArticle>>> {
        return safeApiCall {
            newsApiService.getNationalNews(countryName).articles
        }.map {
            if (it is ApiResponse.Success && it.response.isNotEmpty()) {
                coroutineScope.launch {
                    kmmNewsArticlesDao.insertAllArticles(it.response.toLocalNewsArticles())
                }
            }
            it
        }.flowOn(ioDispatcher)
    }

    override suspend fun getNewsArticleForId(id: Long): NewsArticle {
        return withContext(ioDispatcher){
            kmmNewsArticlesDao.getArticleForId(id).toNewsArticle()
        }
    }
}