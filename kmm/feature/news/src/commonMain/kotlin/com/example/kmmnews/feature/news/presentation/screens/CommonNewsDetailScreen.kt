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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.kmmnews.domain.news.entities.Article
import com.seiko.imageloader.LocalImageLoader
import com.seiko.imageloader.rememberAsyncImagePainter
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

@Composable
fun CommonNewsDetailScreen(article: Article?) {
    if (article == null) return
    val instantNow = Clock.System.now()
    instantNow.toString()  // returns something like 2015-12-31T12:30:00Z
    val instantBefore = Instant.parse(article.publishedAt)
    val d = instantBefore.toLocalDateTime(TimeZone.currentSystemDefault())
    val topBottomPadding = Modifier.padding(top = 8.dp, bottom = 8.dp)


    MaterialTheme {
        val scaffoldState = rememberScaffoldState()
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
                            Icon(Icons.Filled.ArrowBack, "")
                        }
                    }
                )
            }
        ) {
            Surface(color = MaterialTheme.colors.background) {

                Column(modifier = Modifier.padding(8.dp).fillMaxSize()) {
                    Column(
                        modifier = Modifier.verticalScroll(rememberScrollState())
                            .weight(1f)
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
                            style = MaterialTheme.typography.h5
                        )

                        Text(
                            modifier = topBottomPadding,
                            text = "${article.source} | ${d.dayOfMonth}.${d.monthNumber}.${d.year} ${d.time}",
                            style = MaterialTheme.typography.body1,
                            color = Color.Gray
                        )

                        Text(
                            modifier = topBottomPadding,
                            text = article.description
                        )

                        Text(article.content)
                    }
                }
            }
        }
    }
}