package com.example.kmmnews.core.network

import io.ktor.client.engine.okhttp.OkHttp

// Platform specific Configuration
actual fun getPlatformClientEngine() = OkHttp.create()