package com.example.kmmnews.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.kmmnews.feature.news.NewsDetailScreen
import com.example.kmmnews.feature.news.NewsListScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme() {
            }
            val navController = rememberNavController()

            NavHost(navController, startDestination = "home") {
                composable("home") {
                    NewsListScreen(selectedArticleAsJson = {
                        navController.navigate(route = "details/$it")
                    })
                }
                composable(
                    "details/{articleId}",
                    arguments = listOf(
                        navArgument("articleId") {
                            type = NavType.LongType
                            defaultValue = 0L
                        },
                    ),
                ) {
                    NewsDetailScreen(
                        articleId = it.arguments?.getLong("articleId")!!,
                        onBackButtonClick = {
                            navController.navigateUp()
                        },
                    )
                }
            }
        }
    }
}
