package com.example.kmmnews.core.database.di

import com.example.kmmnews.core.common.di.KmmNewsCoroutineDispatcher
import com.example.kmmnews.core.common.di.coroutineModule
import com.example.kmmnews.core.database.KmmDatabase
import com.example.kmmnews.core.database.KmmDatabaseImpl
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module

expect fun dbDriverModule(): Module

val kmmnewsDatabasemodule = module {
    includes(dbDriverModule(), coroutineModule)
    single<KmmDatabase> {
        KmmDatabaseImpl(get(), get(named(KmmNewsCoroutineDispatcher.IO)))
    }
}