package com.example.kmmnews.core.data.di

import com.example.kmmnews.core.data.repos.NewsImpl
import com.example.kmmnews.core.data.repos.News
import org.koin.dsl.module

val repositoryModule = module {
    includes(servicesModule)
    single<News> { NewsImpl(get()) }
}