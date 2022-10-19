package com.example.septemberproject24.presentation.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.septemberproject24.navigation.Screens
import com.example.septemberproject24.ui.theme.fontFamily
import kotlinx.coroutines.launch

@Composable
fun OnSearch(navController: NavController, text: String)
{
    navController.navigate(Screens.MainScreen.name + "/$text")
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchScreen(navController: NavController) {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = Color.Black,
        topBar = {
            TopAppBar(
                backgroundColor = Color.Black,
                title = {
                    Text(
                        text = "Search",
                        color = Color.White,
                        fontStyle = FontStyle.Normal,

                        fontFamily = fontFamily,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 32.sp
                    )
                },
                navigationIcon = {
                    IconButton(
                        modifier = Modifier.background(Color.Black),
                        onClick = {
                            navController.popBackStack()

                        }) {
                        Icon(

                            imageVector = Icons.Default.KeyboardArrowLeft,
                            contentDescription = "Open Menu",
                            tint = Color.White
                        )
                    }
                },

                )
        }
    ) {
        Column() {
            SearchBar() {
                navController.navigate(Screens.MainScreen.name + "/$it")
            }
        }


//                IconButton(
//                    modifier = Modifier
//                        .background(Color.Black)
//                        .size(70.dp),
//                    onClick = {
//                        navController.popBackStack()
//                    }) {
//                    Icon(
//                        modifier = Modifier
//                            .size(40.dp),
//                        imageVector = Icons.Default.KeyboardArrowLeft,
//                        contentDescription = "Open Menu",
//                        tint = Color.White
//                    )
//                }
//                Column() {
//
//
//                    Text(
//                        modifier = Modifier.padding(5.dp),
//                        text = "Type any city",
//                        color = Color.White,
//                        fontStyle = FontStyle.Normal,
//
//                        fontFamily = fontFamily,
//                        fontWeight = FontWeight.SemiBold,
//                        fontSize = 45.sp
//                    )
//
//                }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchBar(

    onSearch: (String) -> Unit
) {
    var text = rememberSaveable { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current
    val valid = remember(text.value){
        text.value.trim().isNotEmpty()
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .padding(start = 10.dp, end = 10.dp),
        textStyle = TextStyle(color = Color.White, fontSize = 24.sp),
        shape = RoundedCornerShape(36.dp),
        value = text.value,
        onValueChange = { text.value = it
        },



        placeholder = {
            Text(
                modifier = Modifier.padding(5.dp),
                text = "Type any city",
                color = Color.White,
                fontStyle = FontStyle.Normal,

                fontFamily = fontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Color.White,
            backgroundColor = Color.Black,
            focusedBorderColor = Color.White,
            cursorColor = Color.White

        ),
        keyboardActions = KeyboardActions {
            if(!valid) return@KeyboardActions
            onSearch(text.value.trim())
            Log.d("find", "SearchBar: ${text.value.trim()}")
            text.value = ""
            keyboardController?.hide()

        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Next),
        maxLines = 1,
        singleLine = true
    )
}
