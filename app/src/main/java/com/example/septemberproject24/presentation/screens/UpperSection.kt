package com.example.septemberproject24.presentation.screens

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.septemberproject24.model.Weather
import com.example.septemberproject24.ui.theme.fontFamily
import com.example.septemberproject24.utils.formatDate
import com.example.septemberproject24.utils.formatDecimals
import java.util.*
import com.example.septemberproject24.R

@Composable
fun LocationAndDate(data: Weather) {
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxWidth(),
verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Row() {
            Icon(
                imageVector = Icons.Default.LocationOn,
                contentDescription = "location",
                tint = Color.White
            )
            Text(
                text = data.city.name + ", " + data.city.country,
                color = Color.White,
                fontStyle = FontStyle.Normal,

                fontFamily = fontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp
            )

        }
        Button(
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Black,
                contentColor = Color.White
            ),
            onClick = {
                Toast.makeText(context, "Hi", Toast.LENGTH_SHORT).show()
            },
            border = BorderStroke(2.dp, Color.White),
            shape = RoundedCornerShape(24.dp)
        ) {
            Text(
                text = formatDate(data.list[0].dt),
                color = Color.White,
                fontStyle = FontStyle.Normal,
                fontFamily = fontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp
            )
        }
    }
}


@Composable
fun WeatherInfo(data: Weather) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val calendar = Calendar.getInstance()


        Image(
            painter = painterResource(
                id =
            if((data.list[0].weather[0].main )== "Rain")
            {
                R.drawable.rain
            }
            else if((data.list[0].weather[0].main )== "Clouds") {
                R.drawable.cloudy
            }
            else{
                R.drawable.raining
            }
            ),
            contentDescription = null,
            modifier = Modifier.size(100.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text =
            when (calendar.get(Calendar.HOUR_OF_DAY)) {
                in 6..11 -> formatDecimals(data.list[0].temp.morn) + "°"
                in 12..17 -> formatDecimals(data.list[0].temp.day) + "°"
                in 18..20 -> formatDecimals(data.list[0].temp.eve) + "°"
                in 21..23 -> formatDecimals(data.list[0].temp.night) + "°"
                else -> formatDecimals(data.list[0].temp.night) + "°"
            },


            color = Color.White,
            fontStyle = FontStyle.Normal,
            fontFamily = fontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 45.sp
        )
        Row() {


            Text(
                text = formatDecimals(data.list[0].temp.max) + "°" + "/" + formatDecimals(data.list[0].temp.min) + "°",
                color = Color.White,
                fontStyle = FontStyle.Normal,
                fontFamily = fontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp
            )
            Text(
                text =
                when (calendar.get(Calendar.HOUR_OF_DAY)) {
                    in 6..11 -> ",  Feels like " + formatDecimals(data.list[0].feels_like.morn) + "°"
                    in 12..17 -> ",  Feels like " + formatDecimals(data.list[0].feels_like.day) + "°"
                    in 18..20 -> ",  Feels like " + formatDecimals(data.list[0].feels_like.eve) + "°"
                    in 21..23 -> ",  Feels like " + formatDecimals(data.list[0].feels_like.night) + "°"
                    else -> ",  Feels like " + formatDecimals(data.list[0].feels_like.night) + "°"
                },


                color = Color.White,
                fontStyle = FontStyle.Normal,
                fontFamily = fontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp
            )


        }
        Text(
            text = data.list[0].weather[0].main,
            color = Color.White,
            fontStyle = FontStyle.Normal,
            fontFamily = fontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 32.sp
        )
    }
}