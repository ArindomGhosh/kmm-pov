package com.example.kmmnews.core.data.di

import com.example.kmmnews.core.data.repos.FakeNews
import com.example.kmmnews.core.data.repos.News
import org.koin.dsl.module

val repositoryModule = module {
    single<News> { FakeNews() }
}