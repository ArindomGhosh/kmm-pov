package com.example.kmmnews.feature.news.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.kmmnews.core.ui.KmmNewsTheme

@Composable
fun CommonNewsScreen(
    newsScreenViewModel: NewsScreenViewModel
) {
    // Todo implement collectAsStateWithLifecycle
    // check: https://developer.android.com/reference/kotlin/androidx/lifecycle/compose/package-summary#(kotlinx.coroutines.flow.Flow).collectAsStateWithLifecycle(kotlin.Any,androidx.lifecycle.Lifecycle,androidx.lifecycle.Lifecycle.State,kotlin.coroutines.CoroutineContext)
    val newsUiState: NewsUiState by newsScreenViewModel.uiState.collectAsState()
    when (newsUiState) {
        is NewsUiState.Error -> Column {
            Text("come err")
        }

        is NewsUiState.Loaded -> {
            KmmNewsTheme {
                Surface(color = MaterialTheme.colors.background) {
//                    Text(
//                        (newsUiState as NewsUiState.Loaded).newsList.joinToString("")
//                    )
                    NewsArticleList(articles = (newsUiState as NewsUiState.Loaded).newsList)
                }
            }

        }

        NewsUiState.Loading -> {
            Column {
                Text("Loading")
            }
        }
    }
}