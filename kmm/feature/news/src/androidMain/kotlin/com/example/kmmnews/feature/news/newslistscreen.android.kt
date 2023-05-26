package com.example.kmmnews.feature.news

import androidx.compose.runtime.Composable
import com.example.kmmnews.feature.news.presentation.screens.CommonNewsScreen
import org.koin.compose.koinInject
import org.koin.core.context.GlobalContext.get

@Composable
fun NewsListScreen(){
    CommonNewsScreen(
        newsScreenViewModel = koinInject()
    )
}