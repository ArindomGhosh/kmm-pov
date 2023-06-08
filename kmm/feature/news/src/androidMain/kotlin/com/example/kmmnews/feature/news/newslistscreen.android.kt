package com.example.kmmnews.feature.news

import androidx.compose.runtime.Composable
import com.example.kmmnews.feature.news.presentation.screens.CommonNewsScreen
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.koin.compose.koinInject

@Composable
fun NewsListScreen(selectedArticleAsJson: (Long) -> Unit) {
    CommonNewsScreen(
        newsScreenViewModel = koinInject(),
        onArticleSelected = {
            selectedArticleAsJson.invoke(it.articleId)
        },
    )
}
