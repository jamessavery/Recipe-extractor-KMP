package com.jimmy.recipeextractor.domain.di

import org.koin.dsl.module

val commonModule = module {
    // Common dependencies here
}

val androidModule = module {
//    single<ClipboardManager> {
//        AndroidClipboardManager(get()) // get() injects Context
//    }
}