package com.example.kmmnews.feature.news.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kmmnews.domain.news.entities.Article
import com.seiko.imageloader.LocalImageLoader
import com.seiko.imageloader.rememberAsyncImagePainter
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

@Composable
fun CommonNewsDetailScreen(
    newsDetailScreenViewModel: NewsDetailsScreenViewModel,
    articleId: Long,
    onBackButtonClick: () -> Unit,
) {
    val newsDetailsUiState: NewsDetailsUiState by newsDetailScreenViewModel.uiState.collectAsState()
    newsDetailScreenViewModel.getArticleFromId(articleId)
    when (newsDetailsUiState) {
        is NewsDetailsUiState.Loading ->
            NewsDetailsLoading()

        is NewsDetailsUiState.Loaded -> NewsDetailsLoaded(
            (newsDetailsUiState as NewsDetailsUiState.Loaded).article,
            onBackButtonClick = onBackButtonClick,
        )
    }
}

@Composable
fun NewsDetailsLoading() {
}

@Composable
fun NewsDetailsLoaded(article: Article, onBackButtonClick: () -> Unit) {
    val formattedDateTime = try {
        val instantBefore = Instant.parse(article.publishedAt)
        val d = instantBefore.toLocalDateTime(TimeZone.currentSystemDefault())
        "${d.dayOfMonth}.${d.monthNumber}.${d.year} ${d.time}"
    } catch (e: Exception) {
        article.publishedAt
    }

    val topBottomPadding = Modifier.padding(top = 8.dp, bottom = 8.dp)

    MaterialTheme {
        val scaffoldState = rememberScaffoldState()
        Scaffold(
            scaffoldState = scaffoldState,
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "Published by ${article.source}",
                            style = MaterialTheme.typography.body1,
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = onBackButtonClick) {
                            Icon(Icons.Filled.ArrowBack, "")
                        }
                    },
                )
            },
        ) {
            Surface(color = MaterialTheme.colors.background) {
                Column(modifier = Modifier.padding(8.dp).fillMaxSize()) {
                    Column(
                        modifier = Modifier.verticalScroll(rememberScrollState())
                            .weight(1f),
                    ) {
                        val resource = rememberAsyncImagePainter(
                            url = article.imageUrl,
                            imageLoader = LocalImageLoader.current,
                        )

                        Image(
                            painter = resource,
                            contentDescription = "",
                            modifier = Modifier
                                .heightIn(min = 180.dp)
                                .fillMaxWidth()
                                .clip(shape = MaterialTheme.shapes.medium),
                        )
                        Text(
                            modifier = topBottomPadding,
                            text = article.title,
                            style = MaterialTheme.typography.h5,
                        )

                        Text(
                            modifier = Modifier.padding(top = 8.dp, bottom = 1.dp),
                            text = "Published by ${article.source}",
                            style = MaterialTheme.typography.overline,
                            color = Color.Gray,
                        )

                        Text(
                            modifier = Modifier.padding(top = 1.dp, bottom = 8.dp),
                            text = formattedDateTime,
                            style = MaterialTheme.typography.overline,
                            color = Color.Gray,
                        )

                        Text(
                            modifier = topBottomPadding,
                            text = article.description,
                            lineHeight = 22.sp,
                            letterSpacing = 0.5.sp,
                        )

                        Text(
                            article.content,
                            lineHeight = 22.sp,
                            letterSpacing = 0.5.sp,
                        )
                    }
                }
            }
        }
    }
}
