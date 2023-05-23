package com.example.kmmnews.feature.news.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kmmnews.feature.news.models.NewsArticle

@Composable
fun NewsArticleList(articles: List<NewsArticle>) {
    LazyColumn {
        items(articles.size) { index ->

            NewsArticleItem(article = articles[index]) { _, _ ->
                // Show the modal dialog
            }
        }
    }
}

@Composable
fun NewsArticleItem(article: NewsArticle, onClick: (String, String)-> Unit) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = 4.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = article.title,
                style = MaterialTheme.typography.h5,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = article.description,
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(top = 8.dp)
            )
            Button(onClick = {
                onClick(article.title, article.description)
            }) {
                Text("Read more")
            }
        }
    }
}

