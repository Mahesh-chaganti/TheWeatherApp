package com.example.septemberproject24.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.septemberproject24.data.defaultCity
import com.example.septemberproject24.navigation.Screens
import com.example.septemberproject24.ui.theme.fontFamily


@Composable
fun SettingsPage(navController: NavController) {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Black
    ) {
        Column() {


            TopAppBar(
                modifier = Modifier.padding(top = 5.dp),
                backgroundColor = Color.Black,
                title = {
                    Text(
                        text = "Settings",
                        color = Color.White,
                        fontStyle = FontStyle.Normal,

                        fontFamily = fontFamily,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 32.sp
                    )
                },
                navigationIcon = {
                    IconButton(
                        modifier = Modifier
                            .background(Color.Black)
                            .size(70.dp),
                        onClick = {
                           navController.popBackStack()
                        }) {
                        Icon(
                            modifier = Modifier
                                .size(35.dp),
                            imageVector = Icons.Default.KeyboardArrowLeft,
                            contentDescription = "Open Menu",
                            tint = Color.White
                        )
                    }

                },
                actions = {

                }
            )
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp),
                ) {
                    Text(
                        text = "Virat",
                        color = Color.White,
                        fontStyle = FontStyle.Normal,

                        fontFamily = fontFamily,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp
                    )

                }
            }
        }


    }
}