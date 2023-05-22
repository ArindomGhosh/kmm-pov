package com.example.kmmnews.feature.news
import androidx.compose.ui.window.ComposeUIViewController
import com.example.kmmnews.feature.news.presentation.screens.CommonNewsScreen
import org.koin.core.component.KoinComponent

@Suppress("unused")
fun NewListScreeController() = ComposeUIViewController { CommonNewsScreen() }
