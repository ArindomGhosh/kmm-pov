package com.example.kmmnews.core.network

import com.example.kmmnews.core.data.dtos.ApiException
import com.example.kmmnews.core.data.dtos.ApiResponse
import com.example.kmmnews.core.data.dtos.NewsArticle
import com.example.kmmnews.core.data.dtos.NewsResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.decodeFromString

class NewsApiServiceImpl(private val client: HttpClient) : NewsApiService {

    override suspend fun getNationalNews(country: String): Flow<ApiResponse<List<NewsArticle>>> {
        val httpResponse = client.get(NewsApiConstants.BASE_URL) {
            url {
                parameters.append("country", country)
                parameters.append("apiKey", NewsApiConstants.API_KEY)
            }
        }
        val json = kotlinx.serialization.json.Json {
            ignoreUnknownKeys = true
        }
        val newsArticleList: NewsResponse = json.decodeFromString(httpResponse.bodyAsText())
        return flow {
            when (httpResponse.status) {
                HttpStatusCode.OK -> emit(ApiResponse.Success(newsArticleList.articles))
                HttpStatusCode.BadRequest -> emit(ApiResponse.Fail(ApiException.BadRequest))
                HttpStatusCode.NotFound -> emit(ApiResponse.Fail(ApiException.NotFound))
                else -> emit(ApiResponse.Fail(ApiException.DefaultException))
            }
        }
    }
}