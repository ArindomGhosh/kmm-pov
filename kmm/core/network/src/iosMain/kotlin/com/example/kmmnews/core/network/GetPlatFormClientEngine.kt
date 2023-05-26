package com.example.kmmnews.core.network

import io.ktor.client.engine.darwin.Darwin

// Platform specific Configuration
actual fun getPlatformClientEngine() = Darwin.create()