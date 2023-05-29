package com.example.kmmnews.feature.news.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Snackbar
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kmmnews.core.ui.KmmNewsTheme
import com.example.kmmnews.domain.news.entities.Article
import kotlinx.coroutines.launch

@Composable
fun CommonNewsScreen(
    newsScreenViewModel: NewsScreenViewModel
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

                is NewsUiState.Loaded -> NewsScreen((newsUiState as NewsUiState.Loaded).newsList)
                is NewsUiState.Loading -> LoadingScreen()
            }
        }
    }
}

@Composable
fun NewsScreen(newsList: List<Article>) {
    Surface(color = MaterialTheme.colors.background) {
        NewsArticleList(articles = newsList)
    }

}

@Composable
fun LoadingScreen() {
    //TODO : Can have its own custom theme, for now using the @KmmNewsTheme.
    Column(
        modifier = Modifier.fillMaxSize().background(MaterialTheme.colors.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        LinearProgressIndicator(
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)

        )
    }
}
