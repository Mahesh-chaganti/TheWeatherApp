package com.example.septemberproject24.repository

import android.util.Log
import com.example.septemberproject24.data.DataOrException
import com.example.septemberproject24.model.Weather
import com.example.septemberproject24.model.WeatherObject
import com.example.septemberproject24.network.WeatherApi
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val api: WeatherApi){
    suspend fun getWeather(cityQuery: String): DataOrException<Weather, Boolean, Exception>{
        val response = try {
            api.getWeather(query = cityQuery)
        }
        catch (e: Exception){
            Log.d("Excep", " $e ")
            return DataOrException(e = e)
        }
        Log.d("Inside", "$response")
        return DataOrException(data = response)
    }
}