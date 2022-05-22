package com.example.testcompose

import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun MyTextField(){
    var text by rememberSaveable { mutableStateOf("")}

    val painterForIconLabel = painterResource(id = R.drawable.ic_baseline_account_balance_24)

    TextField(
        value = text,
        onValueChange = {
            text = it.trim {it == '0'} },
        label = { Text(("Label")) },
        placeholder = {Text("PlaceHOlder")},
        trailingIcon = {Icon(painter = painterForIconLabel, contentDescription = "")},
        isError = (textSizeIsBig(text)),
        visualTransformation = PasswordVisualTransformation(),
        singleLine = true,
        modifier = Modifier.width(300.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),

    )

}

fun textSizeIsBig(text: String): Boolean {
    return text.length > 5
}