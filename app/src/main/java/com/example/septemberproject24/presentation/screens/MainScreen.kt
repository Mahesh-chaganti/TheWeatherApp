package com.example.septemberproject24.presentation.screens

import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.septemberproject24.R
import com.example.septemberproject24.data.DataOrException
import com.example.septemberproject24.data.DayWiseData
import com.example.septemberproject24.data.WeatherCharData
import com.example.septemberproject24.model.Weather
import com.example.septemberproject24.utils.formatDate
import com.example.septemberproject24.utils.formatDecimals

@Composable
fun MainScreen(mainViewModel: MainViewModel = hiltViewModel(), navController: NavController, city : String? ) {

    val weatherData = produceState<DataOrException<Weather, Boolean, Exception>>(
        initialValue = DataOrException(loading = true)
    ) {
        value = mainViewModel.getWeatherData(city = city.toString())
    }.value



    if (weatherData.loading == true) {
        CircularProgressIndicator()
    } else if (weatherData != null) {
        val listWeatherChar = listOf(
            WeatherCharData(
                title = "Wind",
                icon = painterResource(id = R.drawable.wind),
                value = formatDecimals(weatherData.data!!.list[0].speed) + " km/h"
            ),
            WeatherCharData(
                title = "Humidity",
                icon = painterResource(id = R.drawable.raindrop),
                value = weatherData.data!!.list[0].humidity.toString() + "%"
            ),
            WeatherCharData(
                title = "Chance of Rain",
                icon = painterResource(id = R.drawable.raining),
                value = formatDecimals((weatherData.data!!.list[0].pop) * 100) + "%"
            ),
            WeatherCharData(
                title = "Pressure",
                icon = painterResource(id = R.drawable.pressuregauge),
                value = weatherData.data!!.list[0].pressure.toString()
            ),
            WeatherCharData(
                title = "Rain level",
                icon = painterResource(id = R.drawable.heavyrain),
                value = weatherData.data!!.list[0].rain.toString() + "mm"
            )


        )
        val listDayWiseData = listOf(

            DayWiseData(
                text = formatDate(weatherData.data!!.list[1].dt),
                imgurl = "https://openweathermap.org/img/wn/${weatherData.data!!.list[1].weather[0].icon}.png",
                temp = formatDecimals(weatherData.data!!.list[1].temp.max) + " ° " + "/" + formatDecimals(
                    weatherData.data!!.list[1].temp.min
                ) + " ° ",
                weatherCondition = weatherData.data!!.list[1].weather[0].main
            ),
            DayWiseData(
                text = formatDate(weatherData.data!!.list[2].dt),
                imgurl = "https://openweathermap.org/img/wn/${weatherData.data!!.list[2].weather[0].icon}.png",
                temp = formatDecimals(weatherData.data!!.list[2].temp.max) + " ° " + "/" + formatDecimals(
                    weatherData.data!!.list[2].temp.min
                ) + " ° ",
                weatherCondition = weatherData.data!!.list[2].weather[0].main
            ),
            DayWiseData(
                text = formatDate(weatherData.data!!.list[3].dt),
                imgurl = "https://openweathermap.org/img/wn/${weatherData.data!!.list[3].weather[0].icon}.png",
                temp = formatDecimals(weatherData.data!!.list[3].temp.max) + " ° " + "/" + formatDecimals(
                    weatherData.data!!.list[3].temp.min
                ) + " ° ",
                weatherCondition = weatherData.data!!.list[3].weather[0].main
            ),
            DayWiseData(
                text = formatDate(weatherData.data!!.list[4].dt),
                imgurl = "https://openweathermap.org/img/wn/${weatherData.data!!.list[4].weather[0].icon}.png",
                temp = formatDecimals(weatherData.data!!.list[4].temp.max) + " ° " + "/" + formatDecimals(
                    weatherData.data!!.list[4].temp.min
                ) + " ° ",
                weatherCondition = weatherData.data!!.list[4].weather[0].main
            ),
            DayWiseData(
                text = formatDate(weatherData.data!!.list[5].dt),
                imgurl = "https://openweathermap.org/img/wn/${weatherData.data!!.list[5].weather[0].icon}.png",
                temp = formatDecimals(weatherData.data!!.list[5].temp.max) + " ° " + "/" + formatDecimals(
                    weatherData.data!!.list[5].temp.min
                ) + " ° ",
                weatherCondition = weatherData.data!!.list[5].weather[0].main
            ),
            DayWiseData(
                text = formatDate(weatherData.data!!.list[6].dt),
                imgurl = "https://openweathermap.org/img/wn/${weatherData.data!!.list[6].weather[0].icon}.png",
                temp = formatDecimals(weatherData.data!!.list[6].temp.max) + " ° " + "/" + formatDecimals(
                    weatherData.data!!.list[6].temp.min
                ) + " ° ",
                weatherCondition = weatherData.data!!.list[6].weather[0].main
            )


        )
        MainScaffold(
            weather = weatherData.data!!,
            navController = navController,
            listDayWiseData = listDayWiseData,
            listWeatherCharData = listWeatherChar
        )
    }

}

