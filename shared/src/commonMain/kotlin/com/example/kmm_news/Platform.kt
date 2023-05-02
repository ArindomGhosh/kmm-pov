package com.example.kmm_news

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform