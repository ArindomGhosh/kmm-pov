package com.example.kmmnews.domain.news.usecases

import com.example.kmmnews.core.data.dtos.ApiException
import com.example.kmmnews.core.data.dtos.ApiResponse
import com.example.kmmnews.core.data.repos.News
import com.example.kmmnews.domain.news.entities.Article
import com.example.kmmnews.domain.news.entities.Entity
import com.example.kmmnews.domain.news.entities.ErrorEntity
import com.example.kmmnews.domain.news.entities.ErrorType
import com.example.kmmnews.domain.news.entities.toArticle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

class GetNationalNews(
    private val news: News
) {
    suspend operator fun invoke(country: String): Flow<Entity<List<Article>>> {
        return news.getNewForCountry(country)
            .map { apiResponse ->
                when (apiResponse) {
                    is ApiResponse.Fail -> {
                        when (apiResponse.err) {
                            ApiException.BadRequest -> Entity.Fail(
                                err = ErrorEntity(
                                    ErrorType.BadRequest,
                                    "Bad Request",
                                    "Look before you leap."
                                )
                            )

                            ApiException.DefaultException -> Entity.Fail(
                                err = ErrorEntity(
                                    ErrorType.UnKnown,
                                    "UnKnown Error",
                                    "Please try again"
                                )
                            )

                            ApiException.NotFound -> Entity.Fail(
                                err = ErrorEntity(
                                    ErrorType.NoDataFound,
                                    "No Data",
                                    "Please try again latter."
                                )
                            )
                        }
                    }

                    is ApiResponse.Success -> Entity.Success(
                        data = apiResponse.response.map { it.toArticle() }
                    )
                }
            }
            .catch {
                Entity.Fail(
                    err = ErrorEntity(
                        ErrorType.UnKnown,
                        "UnKnown Error",
                        "Please try again"
                    )
                )
            }
    }
}
