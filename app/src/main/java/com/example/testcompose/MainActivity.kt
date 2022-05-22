package com.example.testcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.testcompose.cookBook.RecipeList
import com.example.testcompose.cookBook.defaultRecipes
import com.example.testcompose.ui.theme.TestComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val bottomItems = listOf("firstSplashScreen", "text", "button")
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination


            Scaffold(
                bottomBar = { BottomNavigation {
                bottomItems.forEach { screen ->
                    BottomNavigationItem (
                        selected = currentDestination?.hierarchy?.any {it.route == screen} == true,
                        onClick = { navController.navigate(screen) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        } },
                        icon = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_baseline_account_balance_24),
                                contentDescription = ""
                            )
                               },
                        label = {Text(screen)},
                    )
                }
            }
            }) {}

            NavHost(navController = navController, startDestination = "firstSplashScreen") {
                composable("firstSplashScreen") { MyTextField() }
                composable("text") { myText()}
                composable("button") { WorkWithButton() }
            }
        }
    }

    @Composable
    fun FirstSplashScreen() {
        TestComposeTheme(true) {
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colors.background)
            ) {

                Column{
                    TitleMakenna()
                    SubTitleMakenna()
                }

                Image(
                    painter = painterResource(id = R.drawable.ic_baseline_account_balance_24),
                    contentDescription = "",
                    Modifier
                        .size(250.dp)
                        .padding(bottom = 32.dp)
                )

                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = colorResource(id = R.color.purple_200)
                    ),
                    modifier = Modifier
                        .width(250.dp)
                        .padding(16.dp)

                ) {
                    Text(text = "dsfds")
                }
            }
        }
    }

}
