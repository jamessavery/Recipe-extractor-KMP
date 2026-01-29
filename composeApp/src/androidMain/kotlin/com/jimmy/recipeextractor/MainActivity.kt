package com.jimmy.recipeextractor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jimmy.recipeextractor.presentation.ui.MainViewModel
import com.jimmy.recipeextractor.presentation.ui.RecipeExtractorApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            val viewmodel: MainViewModel = viewModel() // TODO use koin approach
            RecipeExtractorApp(
                viewModel = viewmodel
            )
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}