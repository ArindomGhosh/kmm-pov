package com.example.kmmnews.core.data.utils

import com.example.kmmnews.core.data.dtos.ApiException
import com.example.kmmnews.core.data.dtos.ApiResponse
import io.ktor.client.plugins.ResponseException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

suspend fun <T : Any> safeApiCall(apiCall: suspend () -> T): Flow<ApiResponse<T>> {
    return flow {
        try {
            emit(ApiResponse.Success(apiCall()))
        } catch (exception: Exception) {
            emit(ApiResponse.Fail(ApiException.DefaultException))
        }
    }
}