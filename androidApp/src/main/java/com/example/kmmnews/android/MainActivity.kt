package com.example.kmmnews.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.kmmnews.android.newsdetails.NewsListScreen
import com.example.kmmnews.android.newslist.NewsDetailScreen
import com.example.kmmnews.feature.news.presentation.screens.NewsScreenViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel as koinViewmodel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            NavHost(navController, startDestination = "home") {
                composable("home") {
                    NewsListScreen(onArticleSelected = {
                        navController.navigate(route = "details/${it.articleId}")
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
