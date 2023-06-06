package com.example.kmmnews.database

import android.app.Application
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver

actual class KmmNewsDriverFactory(private val application: Application) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(KmmNewsDataBase.Schema, application, "kmm_new.db")
    }
}