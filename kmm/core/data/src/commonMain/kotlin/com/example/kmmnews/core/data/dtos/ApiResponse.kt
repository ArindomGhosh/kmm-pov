package com.example.kmmnews.core.data.dtos

sealed interface ApiResponse<out T : Any> {
    data class Success<out T : Any>(val response: T) : ApiResponse<T>
    data class Fail(val err: ApiException) : ApiResponse<Nothing>
}

sealed interface ApiException {
    object NotFound : ApiException
    object BadRequest : ApiException
    object DefaultException : ApiException
}
