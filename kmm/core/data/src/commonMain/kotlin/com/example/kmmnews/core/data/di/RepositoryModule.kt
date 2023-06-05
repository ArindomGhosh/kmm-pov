package com.example.kmmnews.core.data.di

import com.example.kmmnews.core.common.di.KmmNewsCoroutineDispatcher
import com.example.kmmnews.core.common.di.KmmNewsCoroutineScopes
import com.example.kmmnews.core.common.di.coroutineModule
import com.example.kmmnews.core.data.repos.NewsImpl
import com.example.kmmnews.core.data.repos.News
import com.example.kmmnews.database.KmmDatabase
import com.example.kmmnews.database.KmmNewsDriverFactory
import com.example.kmmnews.database.di.kmmnewsDatabasemodule
import kotlinx.coroutines.CoroutineDispatcher
import org.koin.core.qualifier.named
import org.koin.dsl.module

val repositoryModule = module {
    includes(servicesModule, kmmnewsDatabasemodule, coroutineModule)
    single<News> {
        NewsImpl(
            get(),
            get<KmmDatabase>().getKmmNewsArticlesDao(),
            get(named(KmmNewsCoroutineDispatcher.IO)),
            get(named(KmmNewsCoroutineScopes.ApplicationScope))
        )
    }
}