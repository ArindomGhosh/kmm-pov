package com.example.kmmnews.core.database.di

import com.example.kmmnews.core.database.KmmNewsDriverFactory
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

actual fun dbDriverModule() = module {
    single { KmmNewsDriverFactory(androidApplication()) }
}