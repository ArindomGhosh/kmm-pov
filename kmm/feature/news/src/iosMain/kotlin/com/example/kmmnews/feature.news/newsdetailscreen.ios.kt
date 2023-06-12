package com.example.kmmnews.feature.news

import androidx.compose.ui.window.ComposeUIViewController
import com.example.kmmnews.domain.news.entities.Article
import com.example.kmmnews.feature.news.presentation.screens.CommonNewsDetailScreen
import com.example.kmmnews.feature.news.presentation.screens.NewsDetailsScreenViewModel

@Suppress("unused")
fun NewDetailScreenController(
    newsDetailScreenViewModel: NewsDetailsScreenViewModel,
    articleId: Long,
    onBackButtonClick: () -> Unit,
) =
    ComposeUIViewController {
        CommonNewsDetailScreen(
            newsDetailScreenViewModel = newsDetailScreenViewModel,
            articleId = articleId,
            onBackButtonClick = onBackButtonClick
        )
    }
