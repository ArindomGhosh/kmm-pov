package com.example.kmmnews.core.common

import kotlinx.coroutines.CoroutineScope

expect abstract class ViewModel() {
    val viewModelScope: CoroutineScope
    protected fun onCleared()
}