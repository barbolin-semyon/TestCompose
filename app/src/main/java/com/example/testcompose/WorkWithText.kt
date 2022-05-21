package com.example.testcompose

import android.graphics.Color
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun myText() {
    Column {
        Text(text = "Hello", color = colorResource(id = R.color.purple_200))
        Text(text = "Hello", fontSize = 43.sp)
        Text(text = "Hello", fontWeight = FontWeight.W900)
        Text(text = "Hello", textDecoration = TextDecoration.Underline)
        Text(text = "Hello")
    }
}

@Preview
@Composable
fun AnnotatedClickableText() {
    val annotatedText = buildAnnotatedString {
        append("Click ")

        // We attach this *URL* annotation to the following content
        // until `pop()` is called
        pushStringAnnotation(
            tag = "URL",
            annotation = "https://developer.android.com"
        )
        withStyle(
            style = SpanStyle(
                color = colorResource(id = R.color.purple_200),
                fontWeight = FontWeight.Bold
            )
        ) {
            append("here")
        }

        pop()
    }

    ClickableText(
        text = annotatedText,
        onClick = { offset ->
            // We check if there is an *URL* annotation attached to the text
            // at the clicked position
            annotatedText.getStringAnnotations(
                tag = "URL", start = offset,
                end = offset
            )
                .firstOrNull()?.let { annotation ->
                    // If yes, we log its value
                    Log.d("Clicked URL", annotation.item)
                }
        }
    )
}