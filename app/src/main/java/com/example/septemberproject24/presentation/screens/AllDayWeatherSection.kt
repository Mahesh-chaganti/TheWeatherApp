package com.example.septemberproject24

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.septemberproject24.data.DayWiseData
import com.example.septemberproject24.navigation.Screens
import com.example.septemberproject24.ui.theme.fontFamily

@Composable
fun AllDayWeather(list: List<DayWiseData>?,navController: NavController) {


    LazyColumn(
        modifier = Modifier
            .requiredHeight(400.dp)
            .padding(20.dp)
    ) {
        items(list!!) {
            DayWise(
                text = it.text,
                imgurl = it.imgurl,
                temp = it.temp,
                weatherCondition = it.weatherCondition,
                navController = navController
            )
        }
    }


}

@Composable
fun DayWise(text: String, imgurl: String, temp: String, weatherCondition: String,navController: NavController) {
    Row(
        modifier = Modifier.clickable { navController.navigate(Screens.DetailsScreen.name) }
            .fillMaxWidth()
            .height(72.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text,
            color = Color.White,
            fontStyle = FontStyle.Normal,
            modifier = Modifier.padding(2.dp),
            fontFamily = fontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp
        )

        ImageIcon(size = 40.dp, url = imgurl)
        Text(
            text = weatherCondition,
            color = Color.White,
            fontStyle = FontStyle.Normal,
            modifier = Modifier.padding(2.dp),
            fontFamily = fontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp
        )
        Text(
            text = temp,
            color = Color.White,
            fontStyle = FontStyle.Normal,
            modifier = Modifier.padding(2.dp),
            fontFamily = fontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp
        )

    }
}

@Composable
fun ImageIcon(size: Dp, url: String) {
    Image(
        painter = rememberImagePainter(data = url),
        contentDescription = null,
        modifier = Modifier.size(size)
    )
}