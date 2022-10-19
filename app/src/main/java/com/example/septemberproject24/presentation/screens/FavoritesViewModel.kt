package com.example.septemberproject24.presentation.screens

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.septemberproject24.model.Favorite
import com.example.septemberproject24.repository.WeatherDbRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(private val weatherDbRepository: WeatherDbRepository) :
    ViewModel() {
    private val _favList = MutableStateFlow<List<Favorite>>(emptyList())
    val favList = _favList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO)
        {
            weatherDbRepository.getFavorites().distinctUntilChanged().collect { listOfFavs ->
                if (listOfFavs.isNullOrEmpty()) {
                    Log.d("TAG", ":Empty favs ")
                } else {
                    _favList.value = listOfFavs
                    Log.d("FAVS", ":${listOfFavs} ")
                }

            }
        }
    }
    fun insertFavorite(favorite: Favorite) = viewModelScope.launch { weatherDbRepository.insertFavorite(favorite)}
    fun updateFavorite(favorite: Favorite) = viewModelScope.launch { weatherDbRepository.insertFavorite(favorite)}
    fun deleteFavorite(favorite: Favorite) = viewModelScope.launch { weatherDbRepository.insertFavorite(favorite)}


}