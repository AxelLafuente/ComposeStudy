package com.example.sololeveling.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.sololeveling.ui.theme.BlueDark
import com.example.sololeveling.ui.theme.BlueLight
import com.example.sololeveling.ui.theme.BlueMain
import com.example.sololeveling.ui.theme.BlueNavi
import java.security.KeyStore.PasswordProtection

@Composable
fun TextFieldCustom(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    hint: String,
    keyboardOptions: KeyboardOptions = KeyboardOptions(),
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    TextField(
        value, onValueChange, modifier, label = {
            Text(text = hint, color = Color.White)
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = BlueLight.copy(alpha = 0.5f),
            cursorColor = Color.White
        ),
        maxLines = 1,
        textStyle = TextStyle(
            color = Color.White,
            fontSize = 18.sp
        ),
        keyboardOptions = keyboardOptions,
        visualTransformation = visualTransformation
    )
}

@Preview
@Composable
private fun TextFieldCustomPreview() {

    var username by remember {
        mutableStateOf("")
    }

    TextFieldCustom(
        value = username,
        onValueChange = {
            username = it
        },
        hint = "Username",
        keyboardOptions = KeyboardOptions()
        )

}