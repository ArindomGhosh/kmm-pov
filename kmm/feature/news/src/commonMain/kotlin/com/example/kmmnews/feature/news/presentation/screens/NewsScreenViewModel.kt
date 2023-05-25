package com.example.kmmnews.feature.news.presentation.screens

import com.example.kmmnews.core.common.ViewModel
import com.example.kmmnews.domain.news.entities.Article
import com.example.kmmnews.domain.news.entities.Entity
import com.example.kmmnews.domain.news.entities.ErrorEntity
import com.example.kmmnews.domain.news.usecases.GetNationalNews
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

sealed interface NewsUiState {
    object Loading : NewsUiState
    data class Loaded(val newsList: List<Article>) : NewsUiState
    data class Error(val errorEntity: ErrorEntity) : NewsUiState
}

class NewsScreenViewModel(
    private val getNationalNews: GetNationalNews,
) : ViewModel() {

    private val _uiState = MutableStateFlow<NewsUiState>(NewsUiState.Loading)

    val currentUiState = _uiState.value

    val uiState: StateFlow<NewsUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
//            getNewsForCountry("Some counrty")
            getNews()
        }
    }

    fun getNewsForCountry(countryName: String) {
        viewModelScope.launch {
            getNationalNews.invoke(countryName)
                .onStart {
                    _uiState.value = NewsUiState.Loading
                }
                .onEach { entity ->
                    when (entity) {
                        is Entity.Fail -> _uiState.value = NewsUiState.Error(
                            entity.err,
                        )

                        is Entity.Success -> _uiState.value = NewsUiState.Loaded(
                            entity.data,
                        )
                    }
                }
                .catch {
                    _uiState.value = NewsUiState.Error(
                        ErrorEntity(),
                    )
                }
                .collect()
        }
    }

    fun getNews() {
        viewModelScope.launch {
            getNationalNews.loadNationalNews("us")
                .onStart {
                    _uiState.value = NewsUiState.Loading
                }
                .onEach { entity ->
                    when (entity) {
                        is Entity.Fail -> _uiState.value = NewsUiState.Error(
                            entity.err,
                        )

                        is Entity.Success -> _uiState.value = NewsUiState.Loaded(
                            entity.data,
                        )
                    }
                }
                .catch {
                    _uiState.value = NewsUiState.Error(
                        ErrorEntity(),
                    )
                }
                .collect()
        }
    }
}
