package com.jimmy.recipeextractor

import platform.UIKit.UIDevice
import platform.UIKit.UIPasteboard

class IOSClipboardManager() : ClipboardManager {
    override fun clipboardContents(): String {
        val pasteboard = UIPasteboard.generalPasteboard()
        return pasteboard.string ?: "invalidJimmy"
    }

}

actual fun getClipboardManager(): ClipboardManager = IOSClipboardManager()