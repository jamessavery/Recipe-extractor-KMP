package com.jimmy.recipeextractor

import org.koin.dsl.module

val androidModule = module {
    single<ClipboardManager> {
        AndroidClipboardManager(get()) // get() injects Context
    }
}