package com.example.kmmnews.core.network

import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.observer.ResponseObserver
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders

class NewsApiClient {
    private val baseURL = "https://newsapi.org/v2/everything"

    private val ktorHTTPClient = HttpClient() {
        install(ResponseObserver) {
            onResponse { it ->
                println(it.status.value)
            }
        }
        install(DefaultRequest) {
            header(HttpHeaders.ContentType, ContentType.Application.Json)
        }
    }

    /*suspend fun fetch(endpoint: String) {
        client.get("$baseURL/$endpoint")
    }*/
}
