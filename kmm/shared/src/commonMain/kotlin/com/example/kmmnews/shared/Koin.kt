package com.example.kmmnews.shared

import com.example.kmmnews.feature.news.di.viewModelModule
import com.example.kmmnews.feature.news.presentation.screens.NewsDetailsScreenViewModel
import com.example.kmmnews.feature.news.presentation.screens.NewsScreenViewModel
import org.koin.core.Koin
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(appDeclaration: KoinAppDeclaration = {}) =
    startKoin {
        appDeclaration()
        modules(
            featureModules
        )
    }

internal val featureModules = module {
    includes(
        viewModelModule
    )
}

fun KoinApplication.Companion.start(): KoinApplication = initKoin { }

// todo: koin-compose issue https://github.com/InsertKoinIO/koin/issues/1588
val Koin.getNewsScreenViewModel: NewsScreenViewModel
    get() = get()
val Koin.getNewsDetailsScreenViewModel: NewsDetailsScreenViewModel
    get() = get()