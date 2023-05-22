package com.example.kmmnews.feature.news.di

import com.example.kmmnews.feature.news.presentation.screens.NewsScreenViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class FeatureComponent : KoinComponent {
    val newsScreenViewModel: NewsScreenViewModel by inject()
}