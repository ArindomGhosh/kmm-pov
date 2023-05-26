package com.example.kmmnews.core.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.HttpRequestRetry
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.URLProtocol
import io.ktor.http.parametersOf
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

// private val baseURL = "https://newsapi.org/v2/everything"

const val TIME_OUT_IN_MILLISECONDS = 5_000L

@Suppress("FunctionName")
fun NewsApiClient(
    host: String,
    clientParams: Map<String, String> = emptyMap(),
    headers: Map<String, String> = emptyMap()
):HttpClient {
    return HttpClient(getPlatformClientEngine()) {
        defaultRequest {
            url {
                protocol = URLProtocol.HTTPS
                this.host = host
                clientParams.forEach {
                    parameters.append(it.key, it.value)
                }
            }
            header(HttpHeaders.ContentType, ContentType.Application.Json)
            headers.forEach {
                header(it.key, it.value)
            }

        }
        install(HttpTimeout) {
            requestTimeoutMillis = TIME_OUT_IN_MILLISECONDS
            connectTimeoutMillis = TIME_OUT_IN_MILLISECONDS
            socketTimeoutMillis = TIME_OUT_IN_MILLISECONDS
        }
        install(HttpRequestRetry) {
            retryOnServerErrors(5)
            exponentialDelay()
        }
        install(ContentNegotiation) {
            json(
                // https://github.com/Kotlin/kotlinx.serialization/blob/master/docs/json.md
                Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                    coerceInputValues = true
                }
            )
        }
    }
}

expect fun getPlatformClientEngine(): HttpClientEngine

