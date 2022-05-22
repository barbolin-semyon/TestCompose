package com.example.testcompose

import android.graphics.Color
import android.text.style.StyleSpan
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun myText() {
    Column {
        Text(text = "Hello", color = colorResource(id = R.color.purple_200))
        Text(text = "Hello", fontSize = 43.sp)
        Text(text = "Hello", fontWeight = FontWeight.W900)
        Text(text = "Hello", textDecoration = TextDecoration.Underline)
        SelectionContainer {
            Text(
                text = "Hellodsfdsfdsfdsfdsf",
                Modifier.width(25.dp),
                maxLines = 1,
                fontSize = 18.sp,
                overflow = TextOverflow.Ellipsis)
        }

    }
}

@Composable
fun SimpleClickableText() {

    val annText = AnnotatedString(
        text = "Kruto",
        spanStyle = SpanStyle(fontSize = 18 .sp),
        paragraphStyle = ParagraphStyle(textAlign = TextAlign.Center)
    )

    ClickableText(
        text = annText,
        onClick = {
            Log.d("Click", "$it")
        })
}

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

@Preview
@Composable
fun TitleMakenna() {
    Text(
        buildAnnotatedString {
        withStyle(style = SpanStyle(
            fontSize = 64.sp,
            color = colorResource(id = R.color.white))
        ) {
            append("Makenna \n")
        }
        withStyle(
            style = SpanStyle(
                color = colorResource(id = R.color.purple_200),
                fontSize = 68.sp)
        ) {
            append("Gallery")
        }
    },
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(top = 16.dp),
        lineHeight = 32.sp
    )
}

@Preview
@Composable
fun SubTitleMakenna() {
    Text(
        buildAnnotatedString {
        withStyle(style = SpanStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold)) {
            append("18K ")
        }
        append("artworks")
    },
        fontSize = 18.sp,
        textAlign = TextAlign.End,
        color = colorResource(id = R.color.white),
        modifier = Modifier.padding(start = 64.dp),
        )
}