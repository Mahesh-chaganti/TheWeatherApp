package com.example.septemberproject24.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.septemberproject24.R
import com.example.septemberproject24.data.defaultCity
import com.example.septemberproject24.navigation.Screens

@Composable
fun SplashScreen(navController: NavController) {
    Surface(modifier = Modifier.fillMaxSize(), color = Color.Black) {

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(
                    id =
                    R.drawable.rain

                ),
                contentDescription = null,
                modifier = Modifier.size(100.dp)
            )
            SearchBar() {
                navController.navigate(Screens.MainScreen.name + "/$it")

            }
        }
    }

}

