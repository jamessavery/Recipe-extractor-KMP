package com.jimmy.recipeextractor

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform