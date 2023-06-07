package com.example.kmmnews.core.database.di


import com.example.kmmnews.core.database.KmmNewsDriverFactory
import org.koin.dsl.module

actual fun dbDriverModule() = module {
    single { KmmNewsDriverFactory() }
}