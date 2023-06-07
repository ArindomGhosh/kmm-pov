package com.example.kmmnews.core.data.services

import com.example.kmmnews.core.data.dtos.NewsResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class NewsApiService(private val client: HttpClient) {
    suspend fun getNationalNews(country: String): NewsResponse {
        val httpResponse = client.get("v2/top-headlines") {
            parameter("country", country)
        }
        return httpResponse.body()
    }
}