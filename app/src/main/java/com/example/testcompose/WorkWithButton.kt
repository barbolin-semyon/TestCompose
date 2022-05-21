package com.example.testcompose

import android.view.animation.BounceInterpolator
import android.widget.Toast
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.SpringSpec
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.icons.materialIcon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.LinearGradient
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WorkWithButton() {

    val count = remember { mutableStateOf(1)}
    val isCheckRadioButton = remember { mutableStateOf(true)}

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        ) {

        Text(text = "${count.value}")

        Button(
            onClick = { count.value += 1},
            modifier = Modifier
                .width(if (isCheckRadioButton.value) 100.dp else 150.dp)
                .padding(8.dp)
                .animateContentSize(animationSpec = tween(1000)),
            ) {
            Row{

                Text("Click", fontSize = 16.sp)
                Spacer(modifier = Modifier.padding(8.dp))
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_account_balance_24),
                    contentDescription = null,
                    tint = colorResource(id = R.color.white)
                )
            }
        }

        OutlinedButton(
            onClick = { count.value +=2 },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .shadow(30.dp)
                .border(
                    width = 5.dp,
                    brush = Brush.linearGradient
                        (
                        colors = listOf
                            (
                            colorResource(id = R.color.purple_200),
                            colorResource(id = R.color.purple_700)
                        )
                    ),
                    shape = RectangleShape
                )
        ) {
            Row{

                Text("Click", fontSize = 16.sp)
                Spacer(modifier = Modifier.padding(8.dp))
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_account_balance_24),
                    contentDescription = null,
                    tint = colorResource(id = R.color.teal_200)
                )
            }
        }

        TextButton(
            onClick = { count.value += 2},
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Row{

                Text("Click", fontSize = 16.sp)
                Spacer(modifier = Modifier.padding(8.dp))
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_account_balance_24),
                    contentDescription = null,
                    tint = colorResource(id = R.color.teal_200)
                )
            }
        }

        FloatingActionButton(
            onClick = { count.value +=2},
            modifier = Modifier
                .padding(8.dp)
                .width(if (isCheckRadioButton.value) 50.dp else 100.dp)
                .height(if (isCheckRadioButton.value) 50.dp else 100.dp)
                .animateContentSize(animationSpec = tween(1000)),
            backgroundColor = colorResource(id = R.color.purple_200),
        ) {
            Row{
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_account_balance_24),
                    contentDescription = null,
                    tint = colorResource(id = R.color.white)
                )
            }
        }



        RadioButton(
            selected = isCheckRadioButton.value,
            onClick = {
                isCheckRadioButton.value = isCheckRadioButton.value.not()
            })

    }
}