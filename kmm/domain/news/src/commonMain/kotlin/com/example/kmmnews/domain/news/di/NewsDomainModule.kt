package com.example.kmmnews.domain.news.di

import com.example.kmmnews.core.data.di.repositoryModule
import com.example.kmmnews.domain.news.usecases.GetNationalNews
import org.koin.dsl.module

val newsDomainModule = module {
    includes(repositoryModule)
    factory { GetNationalNews(news = get()) }
}