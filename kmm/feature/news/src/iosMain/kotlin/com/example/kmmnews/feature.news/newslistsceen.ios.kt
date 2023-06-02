package com.example.kmmnews.feature.news

import androidx.compose.ui.window.ComposeUIViewController
import com.example.kmmnews.feature.news.presentation.screens.CommonNewsScreen
import com.example.kmmnews.feature.news.presentation.screens.NewsScreenViewModel

@Suppress("unused")
fun NewsListScreeController(newsScreenViewModel: NewsScreenViewModel) =
    ComposeUIViewController {
        CommonNewsScreen(
            newsScreenViewModel = newsScreenViewModel,
            onArticleSelected = {},
        )
    }
