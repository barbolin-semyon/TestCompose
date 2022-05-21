package com.example.testcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.ui.Modifier
import com.example.testcompose.cookBook.RecipeList
import com.example.testcompose.cookBook.defaultRecipes
import com.example.testcompose.ui.theme.TestComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent() {
            TestComposeTheme() {
                Column(modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colors.background)) {
                    RecipeList(recipes = defaultRecipes)
                }
            }

        }

    }
}
