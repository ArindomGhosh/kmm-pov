package com.example.kmmnews.feature.news.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.kmmnews.core.ui.KmmNewsTheme
import com.example.kmmnews.feature.news.models.NewsArticle

@Composable
fun CommonNewsScreen(
    newsScreenViewModel: NewsScreenViewModel
) {
    val newsUiState: NewsUiState by newsScreenViewModel.uiState.collectAsState()
    when (newsUiState) {
        is NewsUiState.Error -> Column {
            Text("come err")
        }

        is NewsUiState.Loaded -> {
            KmmNewsTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Text(
                        (newsUiState as NewsUiState.Loaded).newsList.joinToString("")
                    )
//                    NewsArticleList(articles = articles)
                }
            }

        }

        NewsUiState.Loading -> {
            Column {
                Text("Loading")
            }
        }
    }
//    val articles = listOf(
//        NewsArticle(
//            title = "1st article",
//            imageUrl = "https://via.placeholder.com/300x150.png?text=Article+1",
//            description = "This is the first article"
//        ),
//        NewsArticle(
//            title = "2nd article",
//            imageUrl = "https://via.placeholder.com/300x150.png?text=Article+2",
//            description = "This is the second article"
//        ),
//        NewsArticle(
//            title = "3rd article",
//            imageUrl = "https://via.placeholder.com/300x150.png?text=Article+3",
//            description = "This is the third article"
//        ),
//        NewsArticle(
//            title = "4th article",
//            imageUrl = "https://via.placeholder.com/300x150.png?text=Article+4",
//            description = "This is the fourth article"
//        ),
//        NewsArticle(
//            title = "5th article",
//            imageUrl = "https://via.placeholder.com/300x150.png?text=Article+5",
//            description = "This is the fifth article"
//        ),
//        NewsArticle(
//            title = "6th article",
//            imageUrl = "https://via.placeholder.com/300x150.png?text=Article+1",
//            description = "This is the sixth article"
//        ),
//        NewsArticle(
//            title = "7th article",
//            imageUrl = "https://via.placeholder.com/300x150.png?text=Article+2",
//            description = "This is the seventh article"
//        ),
//        NewsArticle(
//            title = "8th article",
//            imageUrl = "https://via.placeholder.com/300x150.png?text=Article+3",
//            description = "This is the eighth article"
//        ),
//        NewsArticle(
//            title = "9th article",
//            imageUrl = "https://via.placeholder.com/300x150.png?text=Article+4",
//            description = "This is the ninth article"
//        ),
//        NewsArticle(
//            title = "10th article",
//            imageUrl = "https://via.placeholder.com/300x150.png?text=Article+5",
//            description = "This is the tenth article"
//        )
//    )
}