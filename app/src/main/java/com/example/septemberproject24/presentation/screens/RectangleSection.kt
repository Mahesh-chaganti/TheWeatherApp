package com.example.septemberproject24.presentation.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.septemberproject24.model.Weather
import com.example.septemberproject24.ui.theme.fontFamily
import com.example.septemberproject24.utils.formatDecimals
import com.example.septemberproject24.R
import com.example.septemberproject24.data.WeatherCharData

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RectangleSection( listWeatherCharData: List<WeatherCharData>) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(10.dp),
        shape = RoundedCornerShape(40.dp),
        backgroundColor = Color.Black,
        border = BorderStroke(width = 2.dp, color = Color.White),

        ) {
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            items(listWeatherCharData) {
                WeatherChars(
                    title = it.title,
                    icon = it.icon,
                    value = it.value
                )
            }


        }
    }
}


@Composable
fun WeatherChars(title: String, icon: Painter, value: String) {
    Row(
        modifier = Modifier.padding(10.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {


        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {

            Image(
                painter = icon, contentDescription = title,
                modifier = Modifier
                    .size(75.dp)
                    .padding(10.dp)
            )
            Text(
                text = value,
                color = Color.White,
                fontStyle = FontStyle.Normal,
                modifier = Modifier.padding(2.dp),
                fontFamily = fontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 12.sp
            )
            Text(
                text = title,
                color = Color.White,
                fontStyle = FontStyle.Normal,
                modifier = Modifier.padding(2.dp),
                fontFamily = fontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 12.sp
            )

        }

    }


}