package com.example.kmmnews.database

import io.github.aakira.napier.Napier
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext

interface KmmNewsArticlesDao {
    suspend fun insertAllArticles(articles: List<NewsArticle>)

    suspend fun getArticles(): List<NewsArticle>

    fun getAllArticles(): Flow<List<NewsArticle>>

    suspend fun getArticleForId(id: Long): NewsArticle

    suspend fun deleteAll()
}

internal class KmmNewsArticlesDaoImpl(
    private val newsArticleQueries: NewsArticleQueries,
    private val ioDispatcher: CoroutineDispatcher
) : KmmNewsArticlesDao {
    override suspend fun insertAllArticles(articles: List<NewsArticle>) {
        withContext(ioDispatcher) {
            newsArticleQueries.transaction {
                afterCommit {
                    Napier.i("DB Transaction Insert:Success")
                }
                afterRollback {
                    Napier.i("DB Transaction Insert:Rollback")
                }
                articles.forEach {
                    newsArticleQueries.insertFullArticle(it)
                }
            }
        }
    }

    override suspend fun getArticles(): List<NewsArticle> {
        return withContext(ioDispatcher) { newsArticleQueries.getAllArticles().executeAsList() }
    }

    override fun getAllArticles(): Flow<List<NewsArticle>> {
        return flow {
            emit(newsArticleQueries.getAllArticles().executeAsList())
        }.flowOn(ioDispatcher)
    }

    override suspend fun getArticleForId(id: Long): NewsArticle {
        return withContext(ioDispatcher) {
            newsArticleQueries.getArticlesForId(id).executeAsOne()
        }
    }

    override suspend fun deleteAll() {
        withContext(ioDispatcher) {
            newsArticleQueries.deleteAllArticles()
        }
    }

}