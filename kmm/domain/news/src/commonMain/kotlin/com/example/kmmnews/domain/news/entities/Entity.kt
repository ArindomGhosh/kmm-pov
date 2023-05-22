package com.example.kmmnews.domain.news.entities

sealed interface Entity <out T:Any>{
    data class Success<out T:Any>(val data:T):Entity<T>
    data class Fail(val err: ErrorEntity):Entity<Nothing>
}

enum class ErrorType{
    UnAuthorized,
    NoDataFound,
    BadRequest,
    Forbidden,
    UnKnown
}

data class ErrorEntity(
    val errorType: ErrorType = ErrorType.UnKnown,
    val message:String="Unknown Error",
    val description:String="Please Try again.",
)