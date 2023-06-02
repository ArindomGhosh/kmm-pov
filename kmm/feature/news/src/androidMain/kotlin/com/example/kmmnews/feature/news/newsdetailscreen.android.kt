package com.example.kmmnews.feature.news

import androidx.compose.runtime.Composable
import com.example.kmmnews.domain.news.entities.Article
import com.example.kmmnews.feature.news.presentation.screens.CommonNewsDetailScreen
import kotlinx.serialization.json.Json

@Composable
fun NewsDetailScreen(article: String, onBackButtonClick: () -> Unit) {
    val tempArticle = Article(
        source = "Gizmodo.com",
                title = "Bitcoin Pyramid Scheme Fraudster Ordered to Pay \$3.4 Billion",
                description =
        "The Commodities Futures Trading Commission patted itself on the back for winning one of the largest civil cases against a crypto crook, even if most—or any—of those affected will see any of their money returned. On Thursday, a Texas judge issued a default jud…",
        imageUrl =
        "https://i.kinja-img.com/gawker-media/image/upload/c_fill,f_auto,fl_progressive,g_center,h_675,pg_1,q_80,w_1200/16e5700ae24064ff50deef40ec83875d.jpg",
                publishedAt = "2023-04-28T14:35:25Z",
                content =
        "The Commodities Futures Trading Commission patted itself on the back for winning one of the largest civil cases against a crypto crook, even if mostor anyof those affected will see any of their money… [+3594 chars]"
    )
    CommonNewsDetailScreen(
//        article = Json.decodeFromString<Article>(article),
        article = tempArticle,
        onBackButtonClick = onBackButtonClick,
    )
}
