package com.example.testcompose.cookBook

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RecipeList(recipes: List<Recipe>) {
    LazyColumn() {
        items(recipes) {
            RecipeCard(recipe = it, Modifier.padding(16.dp).height(144.dp))
        }
    }
}


