package com.example.kmmnews.android.newsdetails

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.SnackbarResult
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.kmmnews.core.ui.KmmNewsTheme
import com.example.kmmnews.core.ui.widgets.LoadingScreen
import com.example.kmmnews.feature.news.domain.entities.Article
import com.example.kmmnews.feature.news.presentation.screens.NewsScreenViewModel
import com.example.kmmnews.feature.news.presentation.screens.NewsUiState
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun NewsListScreen(
    newsScreenViewModel: NewsScreenViewModel = koinViewModel(),
    onArticleSelected: (Article) -> Unit
) {
    // Todo implement collectAsStateWithLifecycle
    // check: https://developer.android.com/reference/kotlin/androidx/lifecycle/compose/package-summary#(kotlinx.coroutines.flow.Flow).collectAsStateWithLifecycle(kotlin.Any,androidx.lifecycle.Lifecycle,androidx.lifecycle.Lifecycle.State,kotlin.coroutines.CoroutineContext)
    KmmNewsTheme {
        val snackbarHostState = remember { SnackbarHostState() }
        Scaffold(
            scaffoldState = rememberScaffoldState(snackbarHostState = snackbarHostState),
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
            Box(modifier = Modifier.padding(it)) {
                val newsUiState: NewsUiState by newsScreenViewModel.uiState.collectAsStateWithLifecycle()
                when (newsUiState) {
                    is NewsUiState.Error -> {
                        LaunchedEffect(snackbarHostState) {
                            val snackbarResult = snackbarHostState.showSnackbar(
                                message = (newsUiState as NewsUiState.Error).errorEntity.message
                            )
                            when (snackbarResult) {
                                SnackbarResult.Dismissed -> {
                                    // dismissed
                                }

                                SnackbarResult.ActionPerformed -> {
                                    // user action performed
                                }
                            }
                        }
                    }

                    is NewsUiState.Loaded -> NewsScreen(
                        (newsUiState as NewsUiState.Loaded).newsList,
                        onArticleSelected = onArticleSelected
                    )

                    is NewsUiState.Loading -> LoadingScreen()
                }
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
