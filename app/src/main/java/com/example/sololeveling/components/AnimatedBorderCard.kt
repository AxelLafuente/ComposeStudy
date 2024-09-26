package com.example.sololeveling.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.sololeveling.ui.theme.*
import java.time.Duration

@Composable
fun AnimatedBorderCard(
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(size = 0.dp),
    borderWidth: Dp = 12.dp,
    gradient: Brush = Brush.sweepGradient(listOf(BlueLight, BlueMain, BlueNavi)),
    animationDuration: Int = 10000,
    content: @Composable () -> Unit
) {

    val infiniteTransition = rememberInfiniteTransition()
    val degrees by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = animationDuration, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    Surface(
        modifier = modifier,
        shape = shape
    ) {
        Surface(modifier = Modifier
            .fillMaxWidth()
            .padding(borderWidth)
            .drawWithContent {
                rotate(degrees = degrees) {
                    drawCircle(
                        brush = gradient,
                        radius = size.width,
                        blendMode = BlendMode.SrcIn
                    )
                }
                drawContent()
            },
            color = BlueNavi.copy(alpha = 0.991f),
            shape = shape
        ) {
            content()
        }
    }

}


@Composable
@Preview
private fun AnimatedBorderCardPreview() {

    Box(modifier = Modifier.fillMaxSize().background(BlueDark), Alignment.Center) {
        AnimatedBorderCard(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            shape = RoundedCornerShape(16.dp),
            borderWidth = 4.dp,
            gradient = Brush.sweepGradient(listOf(BlueDark, BlueLight, Color.White)),
            animationDuration = 10000
        ) {

        }
    }
}