package com.jimmy.recipeextractor

interface ClipboardManager {
    fun clipboardContents(): String
}

expect fun getClipboardManager(): ClipboardManager