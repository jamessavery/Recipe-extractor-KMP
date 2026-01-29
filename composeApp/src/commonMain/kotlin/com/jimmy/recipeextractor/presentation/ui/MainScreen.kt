package com.jimmy.recipeextractor.presentation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jimmy.recipeextractor.presentation.ui.component.DisclaimerText
import com.jimmy.recipeextractor.presentation.ui.component.InstructionsText
import com.jimmy.recipeextractor.presentation.ui.component.TitleText
import com.jimmy.recipeextractor.presentation.ui.component.UrlItem
import org.jetbrains.compose.resources.stringResource

@Composable
fun RecipeExtractorApp(
    viewModel: MainViewModel,
//    openSystemBrowser: (Uri) -> Unit,
//    processToastEvents: (String?) -> Unit,
//    setUrlAlreadyVisited: (Boolean) -> Unit
) {
    LaunchedEffect(viewModel.event) {
        viewModel.event.collect {
//            when (it) {
//                is MainViewModel.Event.SuccessBrowserEvent -> openSystemBrowser(it.parsedUri)
//                is MainViewModel.Event.ToastEvent -> processToastEvents(it.text)
//                is MainViewModel.Event.AlreadyVisitedUrlEvent -> setUrlAlreadyVisited(it.isVisited)
//            }
        }
    }

    Surface(color = MaterialTheme.colorScheme.background) {
        MainScreen()
    }
}

@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {
    Scaffold { contentWindowInsets ->
        Column(
            modifier = modifier.fillMaxSize()
                .padding(contentWindowInsets),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            InstructionsContent(
                Modifier
//                .heightIn(min = 10.dp, max = 160.dp)
                    .weight(4f)
            )

//            HistoryContent(
//                Modifier
//                    .heightIn(min = 400.dp, max = 400.dp)
//                    .weight(6f)
//            )

            DisclaimerContent(
                Modifier
                    .heightIn(min = 70.dp, max = 150.dp)
                    .weight(1f)
            )
        }
    }
}

@Composable
private fun InstructionsContent(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize(),
    ) {
        TitleText(text = "stringResource(id = R.string.instructions_title)")
        InstructionsText(text = "stringResource(id = R.string.instructions)")
    }
}

@Preview
@Composable
private fun HistoryContent(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxHeight(0.6f)
    ) {
        item {
            TitleText(text = "History")
        }
        items(
            items = listOf(
                "https://gemini.google.com/app/5dfc350591c3d9bcasd",
                "https://gemini.google.com/app/5dfc350591c3d9bc",
                "https://gemini.google.com/app/5asdasdasddfc350591c3d9bc",
                "https://gemini.google.com/app/5dfc350591casdasdasd3d9bcasd",
                "https://gemini.google.com/app/5dfc3asgasgadgdgag50591c3d9bc",
                "https://gemini.google.com/app/5asdasdasddasfasfasffc350591c3d9bc"
            ),
            key = { it }
        ) { item ->
            UrlItem(item)
        }
    }
}

// TODO merge into the history LazyColumn as a footer. Limit LC to 3 items & onClick goes to new frag
@Composable
private fun DisclaimerContent(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.BottomCenter
    ) {
        DisclaimerText(
            text = "stringResource(id = R.string.disclaimer)",
            modifier = modifier
        )
    }
}