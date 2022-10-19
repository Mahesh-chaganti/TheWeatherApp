package com.example.septemberproject24.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.septemberproject24.model.Favorite

@Database(entities = [Favorite::class], version = 1, exportSchema = false)
abstract class WeatherDatabase(): RoomDatabase(){
    abstract fun weatherDao(): WeatherDao
}

