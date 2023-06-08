package com.example.kmmnews.feature.news.di

import com.example.kmmnews.domain.news.di.newsDomainModule
import com.example.kmmnews.feature.news.presentation.screens.NewsDetailsScreenViewModel
import com.example.kmmnews.feature.news.presentation.screens.NewsScreenViewModel
import org.koin.dsl.module

val viewModelModule = module {
    includes(newsDomainModule)
    factory { NewsScreenViewModel(get()) }
    factory { NewsDetailsScreenViewModel(get()) }
}