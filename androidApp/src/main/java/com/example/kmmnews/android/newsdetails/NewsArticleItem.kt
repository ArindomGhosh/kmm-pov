package com.example.kmmnews.android.newsdetails

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
import com.example.kmmnews.feature.news.domain.entities.Article

// todo: refactor to use Entity Article from Domain Layer
@Composable
fun NewsArticleList(articles: List<Article>, onArticleSelected: (Article) -> Unit) {
    LazyColumn {
        items(articles.size) { index ->
//            NewsArticleItem(article = articles[index], onClick = onArticleSelected)
            NewsArticleItem(article = articles[index], onClick = onArticleSelected)
        }
    }
}

@Composable
fun NewsArticleItem(article: Article, onClick: (Article) -> Unit) {
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
                onClick(article)
            }) {
                Text("Read more")
            }
        }
    }
}

