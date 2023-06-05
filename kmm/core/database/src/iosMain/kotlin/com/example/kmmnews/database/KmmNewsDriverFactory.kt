package com.example.kmmnews.database

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver

actual class KmmNewsDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(KmmNewsDataBase.Schema, "kmm_new.db")
    }
}