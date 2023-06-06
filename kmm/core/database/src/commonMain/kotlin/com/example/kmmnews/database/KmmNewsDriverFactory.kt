package com.example.kmmnews.database

import app.cash.sqldelight.ColumnAdapter
import app.cash.sqldelight.db.SqlDriver
import kotlinx.coroutines.CoroutineDispatcher

expect class KmmNewsDriverFactory {
    fun createDriver(): SqlDriver
}

interface KmmDatabase {
    fun getKmmNewsArticlesDao(): KmmNewsArticlesDao
}

class KmmDatabaseImpl(
    kmmNewsDriverFactory: KmmNewsDriverFactory,
    private val ioDispatcher: CoroutineDispatcher
) : KmmDatabase {
    private val newsArticleAdapter = object : ColumnAdapter<Map<String, String>, String> {
        override fun decode(databaseValue: String): Map<String, String> {
            val resultMap = mutableMapOf<String, String>()
            return if (databaseValue.isEmpty()) {
                resultMap
            } else {
                val res = databaseValue.split(",")
                res.forEach {
                    val temp = it.split(":")
                    resultMap[temp[0]] = temp[1]
                }
                resultMap
            }
        }

        override fun encode(value: Map<String, String>): String {
            // id:"",name:""
            return value.map { (k, v) ->
                "$k:$v"
            }.joinToString(",")
        }

    }
    private val db = KmmNewsDataBase(
        driver = kmmNewsDriverFactory.createDriver(),
        newsArticleAdapter = NewsArticle.Adapter(
            newsArticleAdapter
        )
    )

    private val newsArticleQueries: NewsArticleQueries = db.newsArticleQueries
    private val newsArticlesDao: KmmNewsArticlesDao = KmmNewsArticlesDaoImpl(
        newsArticleQueries, ioDispatcher
    )

    override fun getKmmNewsArticlesDao(): KmmNewsArticlesDao {
        return newsArticlesDao
    }
}
