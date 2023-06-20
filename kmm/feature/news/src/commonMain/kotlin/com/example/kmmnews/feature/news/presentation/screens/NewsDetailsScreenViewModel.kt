package com.example.kmmnews.feature.news.presentation.screens

import com.example.kmmnews.core.common.ViewModel
import com.example.kmmnews.feature.news.domain.entities.Article
import com.example.kmmnews.feature.news.domain.usecases.GetArticleFromID
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed interface NewsDetailsUiState {
    object Loading : NewsDetailsUiState
    data class Loaded(val article: Article) : NewsDetailsUiState
}

class NewsDetailsScreenViewModel(private val getArticleFromID: GetArticleFromID) : ViewModel() {

    private val _uiState = MutableStateFlow<NewsDetailsUiState>(NewsDetailsUiState.Loading)
    val uiState: StateFlow<NewsDetailsUiState> = _uiState.asStateFlow()

    fun getArticleFromId(articleId: Long) {
        viewModelScope.launch {
            getArticleFromID.invoke(articleId).also {
                _uiState.value = NewsDetailsUiState.Loaded(it)
            }
        }
    }
}