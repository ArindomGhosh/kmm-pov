package com.example.kmmnews.feature.news.di

import com.example.kmmnews.domain.news.di.domainModule
import com.example.kmmnews.feature.news.presentation.screens.NewsScreenViewModel
import org.koin.dsl.module

val viewModelModule = module {
    includes(domainModule)
    factory { NewsScreenViewModel(get()) }
}