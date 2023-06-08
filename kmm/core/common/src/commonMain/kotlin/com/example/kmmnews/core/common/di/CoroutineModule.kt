package com.example.kmmnews.core.common.di

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.SupervisorJob
import org.koin.core.qualifier.named
import org.koin.dsl.module

enum class KmmNewsCoroutineDispatcher {
    IO,
    Main,
    MainImmediate,
    Default
}

enum class KmmNewsCoroutineScopes {
    ApplicationScope
}

val coroutineModule = module {
    single(named(KmmNewsCoroutineDispatcher.IO)) {
        Dispatchers.IO
    }

    single(named(KmmNewsCoroutineDispatcher.Main)) {
        Dispatchers.Main
    }

    single(named(KmmNewsCoroutineDispatcher.Default)) {
        Dispatchers.Default
    }

    single(named(KmmNewsCoroutineDispatcher.MainImmediate)) {
        Dispatchers.Main.immediate
    }

    single(named(KmmNewsCoroutineScopes.ApplicationScope)) {
        CoroutineScope(SupervisorJob() + get<CoroutineDispatcher>(named(KmmNewsCoroutineDispatcher.Default)))
    }
}