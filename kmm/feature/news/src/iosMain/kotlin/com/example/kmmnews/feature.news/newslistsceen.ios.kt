package com.example.kmmnews.feature.news

import androidx.compose.ui.window.ComposeUIViewController
import com.example.kmmnews.feature.news.presentation.screens.CommonNewsScreen
import com.example.kmmnews.feature.news.presentation.screens.NewsScreenViewModel
import org.koin.core.component.KoinComponent

@Suppress("unused")
fun NewListScreeController(newsScreenViewModel: NewsScreenViewModel) =
    ComposeUIViewController { CommonNewsScreen(newsScreenViewModel) }
