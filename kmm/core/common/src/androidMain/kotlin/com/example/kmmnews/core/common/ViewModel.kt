package com.example.kmmnews.core.common

import kotlinx.coroutines.CoroutineScope
import androidx.lifecycle.ViewModel as AndroidViewModel
import androidx.lifecycle.viewModelScope as androidXViewModelScope

actual abstract class ViewModel : AndroidViewModel() {
    actual val viewModelScope: CoroutineScope = androidXViewModelScope
    actual override fun onCleared() {
        super.onCleared()
    }
}