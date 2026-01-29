package com.jimmy.recipeextractor

import androidx.compose.ui.window.ComposeUIViewController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jimmy.recipeextractor.presentation.ui.MainViewModel
import com.jimmy.recipeextractor.presentation.ui.RecipeExtractorApp

fun MainViewController() = ComposeUIViewController {


    val viewmodel: MainViewModel = viewModel { MainViewModel() }
    val clipboardManager = IOSClipboardManager() // TODO hook this up

    RecipeExtractorApp(viewmodel)
}