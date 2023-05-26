package com.example.kmmnews.core.data.di

import com.example.kmmnews.core.data.services.NewsApiService
import com.example.kmmnews.core.network.NewsApiClient
import org.koin.dsl.module

val servicesModule = module {
    single {
        NewsApiService(
            NewsApiClient(
                host = "newsapi.org",
                clientParams = mapOf(
                    "apiKey" to "686cdcefc50a457dbf1cef6c821eafc3"
                )
            )
        )
    }
}