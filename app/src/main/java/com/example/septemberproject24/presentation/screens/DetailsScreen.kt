package com.example.septemberproject24.presentation.screens

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.septemberproject24.ui.theme.fontFamily
import kotlin.math.max
import kotlin.math.min

@Composable
fun DetailsScreen(navController: NavController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Black
    ) {
        Column() {


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(24.dp)
            ) {

            }
            InfoSection()

            WeatherParameters()
            Text(
                text = "Kobe Bryant",
                color = Color.White,
                fontStyle = FontStyle.Normal,

                fontFamily = fontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 32.sp
            )
        }
    }
}

@Composable
fun WeatherParameters() {

}

@Preview
@Composable
fun InfoSection() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val animateTween by rememberInfiniteTransition().animateFloat(
            initialValue = 0f,
            targetValue = 1f,
            animationSpec = infiniteRepeatable(
                tween(durationMillis = 5, easing = LinearEasing),
                RepeatMode.Restart //start anim
            )
        )

//        Canvas(modifier = Modifier.size(200.dp)) {
//
//            // scope ： range of drawing
//            val width = size.width
//            val x: Float = size.width / 2
//
//            val scopeHeight = size.height - width / 2
//
//            // gap of 2 lines
//            val space = size.height / 2.2f + width / 2
//            val spacePos = scopeHeight * animateTween
//            val sy1 = spacePos - space / 2
//            val sy2 = spacePos + space / 2
//
//            // line length
//            val lineHeight = scopeHeight - space
//
//            // line1
//            val line1y1 = max(0f, sy1 - lineHeight)
//            val line1y2 = max(line1y1, sy1)
//
//            // line2
//            val line2y1 = min(sy2, scopeHeight)
//            val line2y2 = min(line2y1 + lineHeight, scopeHeight)
//
//            // draw
//            drawLine(
//                Color.Black,
//                Offset(x, line1y1),
//                Offset(x, line1y2),
//                strokeWidth = width,
//                colorFilter = ColorFilter.tint(
//
//                    Color.Black
//                ),
//                cap = StrokeCap.Round
//            )
//
//            drawLine(
//                Color.Black,
//                Offset(x, line2y1),
//                Offset(x, line2y2),
//                strokeWidth = width,
//                colorFilter = ColorFilter.tint(
//                    Color.Black
//                ),
//                cap = StrokeCap.Round
//            )
//        }
    }
}

