package com.example.kmmnews.network

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform