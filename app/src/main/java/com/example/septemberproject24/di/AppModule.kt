package com.example.septemberproject24.di

import android.content.Context
import androidx.room.Room
import com.example.septemberproject24.data.WeatherDao
import com.example.septemberproject24.data.WeatherDatabase
import com.example.septemberproject24.model.WeatherObject
import com.example.septemberproject24.network.WeatherApi
import com.example.septemberproject24.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideDao(weatherDatabase: WeatherDatabase):WeatherDao = weatherDatabase.weatherDao()

@Provides
@Singleton
fun provideDatabase(@ApplicationContext context: Context):WeatherDatabase
 = Room.databaseBuilder(
    context,
    WeatherDatabase::class.java,
    "weather_database")
    .fallbackToDestructiveMigration()
    .build()

    @Provides
    @Singleton
    fun provideOpenWeatherApi(): WeatherApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApi::class.java)
    }
}