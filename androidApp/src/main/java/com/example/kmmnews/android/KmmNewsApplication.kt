package com.example.kmmnews.android

import android.app.Application
import com.example.kmmnews.feature.news.di.viewModelModule
import com.example.kmmnews.shared.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class KmmNewsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            // Log Koin into Android logger
            androidLogger()
            // Reference Android context
            androidContext(this@KmmNewsApplication)
            // Load modules
            modules(viewModelModule)
        }
    }

}