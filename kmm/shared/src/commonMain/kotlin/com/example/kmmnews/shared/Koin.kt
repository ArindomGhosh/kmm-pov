package com.example.kmmnews.shared

import com.example.kmmnews.feature.news.di.viewModelModule
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