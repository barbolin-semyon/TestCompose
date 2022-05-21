package com.example.testcompose.cookBook

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun RecipeCard(recipe: Recipe, modifier: Modifier) {

    val myHeight = remember {
        mutableStateOf(144.dp)
    }

    Surface(shape = RoundedCornerShape(8.dp), elevation = 8.dp, modifier = modifier) {
        val image = painterResource(id = recipe.imageResource)
        Column(modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.primary)) {
            Image(
                painter = image,
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(144.dp)
            )

            Column(modifier = Modifier.padding(16.dp)) {
                Text(recipe.title, style = MaterialTheme.typography.h4)

                for (ingredient in recipe.ingredients) {
                    Text(text = "• $ingredient")
                }
            }
        }
    }
}

@Composable
@Preview
fun  DefaultRecipeCard () {
    RecipeCard(defaultRecipes[0], Modifier.padding(16.dp))
}