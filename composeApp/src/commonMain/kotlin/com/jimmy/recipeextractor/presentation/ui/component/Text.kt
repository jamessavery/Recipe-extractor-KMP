package com.jimmy.recipeextractor.presentation.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TitleText(text: String) = Text(fontSize = 25.sp, text = text, textAlign = TextAlign.Center)

@Composable
fun InstructionsText(text: String) =
    Text(fontSize = 20.sp, textAlign = TextAlign.Center, text = text)

@Composable
fun DisclaimerText(text: String, modifier: Modifier) =
    Text(
        fontSize = 15.sp,
        textAlign = TextAlign.Center,
        text = text, lineHeight = 14.sp,
        color = Color.Gray,
        modifier = modifier
    )

@Composable
fun UrlItem(url: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { /* TODO open new screen */ }
    ) {
        Text(
            text = url,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(16.dp)
        )
    }
}


// TODO
@Composable
fun ParagraphWithClickableText(preText: String, postText: String) {
    val annotatedString = buildAnnotatedString {
        append(preText)
        pushStringAnnotation(tag = "URL", annotation = "https://example.com")
        withStyle(
            style = SpanStyle(
                color = Color.Blue,
                textDecoration = TextDecoration.Underline
            )
        ) {
            append(" Something ")
        }
        pop()
        append(postText)
    }

    Text(
        text = annotatedString,
        style = TextStyle(fontSize = 16.sp),
        modifier = Modifier.clickable {
            println("Text clicked!")
        }
    )
}

@Preview(showBackground = true)
@Composable
fun ParagraphWithClickableTextPreview() {
    ParagraphWithClickableText("The interventricular septum (IVS, o",
        "The interventricular septum (IVS, or ventricular septum, or during development septum inferius) is the sto"
    )
}