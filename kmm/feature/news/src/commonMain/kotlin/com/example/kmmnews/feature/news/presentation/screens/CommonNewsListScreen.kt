package com.example.kmmnews.feature.news.presentation.screens

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarResult
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import com.example.kmmnews.core.ui.KmmNewsTheme
import com.example.kmmnews.core.ui.widgets.LoadingScreen
import com.example.kmmnews.domain.news.entities.Article
import kotlinx.coroutines.launch

@Composable
internal fun CommonNewsScreen(
    newsScreenViewModel: NewsScreenViewModel,
    onArticleSelected: (Article) -> Unit
) {
    // Todo implement collectAsStateWithLifecycle
    // check: https://developer.android.com/reference/kotlin/androidx/lifecycle/compose/package-summary#(kotlinx.coroutines.flow.Flow).collectAsStateWithLifecycle(kotlin.Any,androidx.lifecycle.Lifecycle,androidx.lifecycle.Lifecycle.State,kotlin.coroutines.CoroutineContext)
    KmmNewsTheme {
        val scaffoldState = rememberScaffoldState()
        val coroutineScope = rememberCoroutineScope()
        Scaffold(
            scaffoldState = scaffoldState,
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "Top news")
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            //TODO : Future state - TO be updated when drawer is integrated
                        }) {
                            Icon(Icons.Filled.Menu, "")
                        }
                    }
                )
            }
        ) {
            val newsUiState: NewsUiState by newsScreenViewModel.uiState.collectAsState()
            when (newsUiState) {
                is NewsUiState.Error -> coroutineScope.launch {
                    val snackbarResult =scaffoldState.snackbarHostState.showSnackbar(
                        message = (newsUiState as NewsUiState.Error).errorEntity.message
                    )
                    when(snackbarResult){
                        SnackbarResult.Dismissed -> {
                            // dismissed
                        }
                        SnackbarResult.ActionPerformed -> {
                            // user action performed
                        }
                    }
                }

                is NewsUiState.Loaded -> NewsScreen((newsUiState as NewsUiState.Loaded).newsList, onArticleSelected = onArticleSelected)
                is NewsUiState.Loading -> LoadingScreen()
            }
        }
    }
}

@Composable
internal fun NewsScreen(newsList: List<Article>, onArticleSelected: (Article) -> Unit) {
    Surface(color = MaterialTheme.colors.background) {
        NewsArticleList(articles = newsList, onArticleSelected = onArticleSelected)
    }
}
