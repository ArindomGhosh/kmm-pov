package com.example.kmmnews.feature.news

import androidx.compose.runtime.Composable
import com.example.kmmnews.feature.news.presentation.screens.CommonNewsDetailScreen
import org.koin.compose.koinInject

@Composable
fun NewsDetailScreen(articleId: Long, onBackButtonClick: () -> Unit) {
    CommonNewsDetailScreen(
        newsDetailScreenViewModel = koinInject(),
        articleId = articleId,
        onBackButtonClick = onBackButtonClick,
    )
}
