package com.example.sololeveling.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sololeveling.R
import com.example.sololeveling.components.AnimatedBorderCard
import com.example.sololeveling.components.TextFieldCustom
import com.example.sololeveling.ui.theme.*
import com.loc.composeglowingcard.GlowingCard

@OptIn(ExperimentalTextApi::class)
@Composable

fun LogIn() {

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.sweepGradient(
                    listOf(
                        BlueDark,
                        BlackMain,
                        BlueDark
                    )
                )
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            fontSize = 36.sp,
            fontFamily = foeFontFamily,
            color = BlueWhite,
            fontWeight = FontWeight.Bold,
            style = TextStyle(
                brush = Brush.horizontalGradient(
                    listOf(BlueLight, BlueWhite, Color.White)
                )
            )
        )

        Spacer(modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 50.dp))


        //
        GlowingCard(
            modifier = Modifier
                .wrapContentSize()
                .padding(all = 45.dp),
            glowingColor = Color.White,
            cornersRadius = 6.dp,
            glowingRadius = 16.dp
        ) {

            AnimatedBorderCard(
                modifier = Modifier,
                shape = RoundedCornerShape(6.dp),
                borderWidth = 1.dp,
                gradient = Brush.sweepGradient(
                    listOf(
                        BlackMain, BlueDark, BlueLight,
                        Color.White, BlueLight, BlueDark,BlackMain, BlueDark, BlueLight,
                        Color.White, BlueLight, BlueDark,BlackMain, BlueDark, BlueLight,
                        Color.White, BlueLight, BlueDark,
                    )
                ),
                animationDuration = 15000
            ) {

                Column(
                    modifier = Modifier.padding(all = 24.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TextFieldCustom(
                        value = username,
                        onValueChange = {
                            username = it
                        },
                        hint = "Username",
                        modifier = Modifier.padding(vertical = 12.dp)
                    )
                    TextFieldCustom(
                        value = password,
                        onValueChange = {
                            password = it
                        },
                        hint = "Password",
                        modifier = Modifier.padding(vertical = 12.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        visualTransformation = PasswordVisualTransformation()
                    )
                }
            }
        }
    }

}

@Composable
@Preview
private fun LogInPreview() {
    LogIn()
} 