package com.jimmy.recipeextractor

import android.app.Application
import com.jimmy.recipeextractor.domain.di.androidModule
import com.jimmy.recipeextractor.domain.di.commonModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class RecipeExtractorApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@RecipeExtractorApp) // Provides applicationContext
            modules(commonModule, androidModule)
        }
    }
}
