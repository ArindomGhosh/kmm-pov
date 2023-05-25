package com.example.kmmnews.core.network

import com.example.kmmnews.core.data.dtos.ApiResponse
import com.example.kmmnews.core.data.dtos.NewsArticle
import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.observer.ResponseObserver
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import kotlinx.coroutines.flow.Flow

// todo ad ktor
interface NewsApiService {
    suspend fun getNationalNews(country: String): Flow<ApiResponse<List<NewsArticle>>>

    companion object {
        fun create(): NewsApiService {
            return NewsApiServiceImpl(
                client = HttpClient() {
                    install(ResponseObserver) {
                        onResponse { it ->
                            println(it.status.value)
                        }
                    }
                    install(DefaultRequest) {
                        header(HttpHeaders.ContentType, ContentType.Application.Json)
                    }
                },
            )
        }
    }
}
