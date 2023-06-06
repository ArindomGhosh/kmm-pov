package com.example.kmmnews.database.di


import com.example.kmmnews.database.KmmNewsDriverFactory
import org.koin.dsl.module

actual fun dbDriverModule() = module {
    single { KmmNewsDriverFactory() }
}