package com.example.kmmnews.core.database

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.example.kmmnews.database.KmmNewsDataBase

actual class KmmNewsDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(KmmNewsDataBase.Schema, "kmm_new.db")
    }
}