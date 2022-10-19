package com.example.septemberproject24.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.septemberproject24.model.Weather
import com.example.septemberproject24.ui.theme.fontFamily
import com.example.septemberproject24.utils.formatDateTime
import com.example.septemberproject24.R

@Composable
fun SunRiseSet(data: Weather) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {


            Text(
                text = "Sunrise",
                color = Color.White,
                fontStyle = FontStyle.Normal,
                modifier = Modifier.padding(2.dp),
                fontFamily = fontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp
            )
            Text(
                text = formatDateTime(data.list[0].sunrise),
                color = Color.White,
                fontStyle = FontStyle.Normal,
                modifier = Modifier.padding(2.dp),
                fontFamily = fontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp
            )

            Image(
                modifier = Modifier.size(100.dp),
                painter = painterResource(id = R.drawable.sunrise),
                contentDescription = "SunRise",
                alignment = Alignment.Center,
                contentScale = ContentScale.Fit
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "Sunset",
                color = Color.White,
                fontStyle = FontStyle.Normal,
                modifier = Modifier.padding(2.dp),
                fontFamily = fontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp
            )
            Text(
                text = formatDateTime(data.list[0].sunset),
                color = Color.White,
                fontStyle = FontStyle.Normal,
                modifier = Modifier.padding(2.dp),
                fontFamily = fontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp
            )
            Image(
                modifier = Modifier.size(100.dp),
                painter = painterResource(id = R.drawable.sunset),
                contentDescription = "SunSet",
                alignment = Alignment.Center,
                contentScale = ContentScale.Fit
            )
        }
    }


}
