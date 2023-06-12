package com.example.kmmnews.domain.news.di

import com.example.kmmnews.core.data.di.repositoryModule
import com.example.kmmnews.domain.news.usecases.GetArticleFromID
import com.example.kmmnews.domain.news.usecases.GetNationalNews
import org.koin.dsl.module

val newsDomainModule = module {
    includes(repositoryModule)
    single { GetNationalNews(news = get()) }
    single { GetArticleFromID(news = get()) }
}