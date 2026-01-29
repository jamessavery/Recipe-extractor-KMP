package com.jimmy.recipeextractor

import android.app.Application
import android.content.Context.CLIPBOARD_SERVICE
import org.koin.mp.KoinPlatform.getKoin

class AndroidClipboardManager(val applicationContext: Application) : ClipboardManager {
    override fun clipboardContents(): String {
        val clipboardManager =
            applicationContext.getSystemService(CLIPBOARD_SERVICE) as android.content.ClipboardManager

        val clipData = clipboardManager.primaryClip

        val copiedText = clipData?.getItemAt(0)?.text?.toString()

        if (copiedText.isNullOrEmpty()) {
            println("JIMMY212 Empty clipboard")
        } else {
            println("JIMMY212 title - ")
        }

        return copiedText ?: "InvalidJimmy"
    }
// TODO plug up iOS, cleanup then push..
}

actual fun getClipboardManager(): ClipboardManager {
    return getKoin().get() // Get from Koin DI container
}