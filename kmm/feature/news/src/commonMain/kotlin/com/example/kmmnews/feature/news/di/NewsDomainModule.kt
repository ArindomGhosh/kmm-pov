package com.example.kmmnews.feature.news.di

import com.example.kmmnews.core.data.di.repositoryModule
import com.example.kmmnews.feature.news.domain.usecases.GetArticleFromID
import com.example.kmmnews.feature.news.domain.usecases.GetNationalNews
import org.koin.dsl.module

val newsDomainModule = module {
    includes(repositoryModule)
    single { GetNationalNews(news = get()) }
    single { GetArticleFromID(news = get()) }
}