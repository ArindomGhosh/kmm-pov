package com.example.kmmnews.domain.common.utils

import com.example.kmmnews.core.data.dtos.ApiException
import com.example.kmmnews.core.data.dtos.ApiResponse
import com.example.kmmnews.domain.common.entities.Entity
import com.example.kmmnews.domain.common.entities.ErrorEntity
import com.example.kmmnews.domain.common.entities.ErrorType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map


fun <T : Any, R : Any> Flow<ApiResponse<T>>.mapToEntity(
    mapper: T.() -> R
): Flow<Entity<R>> {
    return map { apiResponse ->
        when (apiResponse) {
            is ApiResponse.Fail -> {
                when (apiResponse.err) {
                    ApiException.BadRequest -> Entity.Fail(
                        err = ErrorEntity(
                            ErrorType.BadRequest,
                            "Bad Request",
                            "Look before you leap.",
                        ),
                    )

                    ApiException.DefaultException -> Entity.Fail(
                        err = ErrorEntity(
                            ErrorType.UnKnown,
                            "UnKnown Error",
                            "Please try again",
                        ),
                    )

                    ApiException.NotFound -> Entity.Fail(
                        err = ErrorEntity(
                            ErrorType.NoDataFound,
                            "No Data",
                            "Please try again latter.",
                        ),
                    )
                }
            }

            is ApiResponse.Success -> Entity.Success(
                data = apiResponse.response.mapper(),
            )
        }
    }
        .catch {
            Entity.Fail(
                err = ErrorEntity(
                    ErrorType.UnKnown,
                    "UnKnown Error",
                    "Please try again",
                ),
            )
        }

}