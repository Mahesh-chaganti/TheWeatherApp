package com.example.septemberproject24.presentation.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.septemberproject24.AllDayWeather
import com.example.septemberproject24.data.DayWiseData
import com.example.septemberproject24.data.WeatherCharData
import com.example.septemberproject24.model.Weather
import com.example.septemberproject24.navigation.Screens
import com.example.septemberproject24.ui.theme.fontFamily
import kotlinx.coroutines.launch
import com.example.septemberproject24.presentation.screens.DrawerButton


@Composable
fun MainScaffold(

    weather: Weather,
    navController: NavController,
    listDayWiseData: List<DayWiseData>?,
    listWeatherCharData: List<WeatherCharData>
) {

    var expandedDropDown = remember { mutableStateOf(false) }
    var openDialog = remember { mutableStateOf(false) }
    val context = LocalContext.current
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val scrollState = rememberScrollState()
    val reverseScrollState = remember {
        mutableStateOf(false)
    }
    if (expandedDropDown.value) {
        ShowDropDownMenu(
            expandedDropDown = expandedDropDown,
            navController = navController,
            openDialog = openDialog
        )
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        scaffoldState = scaffoldState,
        contentColor = Color.Black,
        backgroundColor = Color.Black,


        topBar = {


            TopAppBar(
                backgroundColor = Color.Black,
                title = {
                    Text(
                        text = "The Weather App",
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

                            scope.launch {
                                if (scaffoldState.drawerState.isOpen)
                                    scaffoldState.drawerState.close()
                                else if (scaffoldState.drawerState.isClosed)
                                    scaffoldState.drawerState.open()
                            }

                        }) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Open Menu",
                            tint = Color.White
                        )
                    }
                },
                actions = {
                    // RowScope here, so these icons will be placed horizontally
                    IconButton(onClick = {
                        navController.navigate(Screens.SearchScreen.name)
                    }) {
                        Icon(
                            Icons.Filled.FavoriteBorder,
                            contentDescription = "Localized description",
                            tint = Color.Black
                        )
                    }

                    IconButton(onClick = {
                        navController.navigate(Screens.SearchScreen.name)
                    }) {
                        Icon(
                            Icons.Filled.Search,
                            contentDescription = "Localized description",
                            tint = Color.White
                        )
                    }
                    IconButton(onClick = {
                        expandedDropDown.value = true
                    }) {
                        Icon(
                            Icons.Filled.MoreVert,
                            contentDescription = "Localized description",
                            tint = Color.White
                        )
                    }

                }
            )


        },


    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(scrollState, reverseScrolling = reverseScrollState.value)
                .padding(top = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            if (openDialog.value) {
                AlertDialog(
                    onDismissRequest = {
                        openDialog.value = false
                    },
                    title = {
                        Text(
                            text = "About",
                            color = Color.White,
                            fontStyle = FontStyle.Normal,

                            fontFamily = fontFamily,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 24.sp
                        )
                    },
                    text = {
                        Text(
                            text = "Hi, My name is Mahesh." + "\n" +
                                    "This is my first app. Show some respect.",
                            color = Color.White,
                            fontStyle = FontStyle.Normal,

                            fontFamily = fontFamily,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 18.sp
                        )

                    },
                    buttons = {
                        Row(
                            modifier = Modifier.padding(all = 8.dp),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Button(
                                modifier = Modifier.fillMaxWidth(),
                                onClick = { openDialog.value = false },
                                border = BorderStroke(color = Color.White, width = 2.dp),
                                shape = RoundedCornerShape(5.dp),
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = Color.Black,
                                    contentColor = Color.White
                                )
                            ) {
                                Text(
                                    text = "Dismiss",
                                    color = Color.White,
                                    fontStyle = FontStyle.Normal,

                                    fontFamily = fontFamily,
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 18.sp
                                )
                            }
                        }
                    }
                )
            }
            Card(
                modifier = Modifier
                    .clickable {
                        navController.navigate(Screens.DetailsScreen.name)
                    }
                    .fillMaxWidth(),
                backgroundColor = Color.Black
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {


                    LocationAndDate(data = weather)
                    WeatherInfo(data = weather)
                }
            }


//                if (scrollState.value == 0 && !reverseScrollState.value) {
//
//                    Column(
//                        modifier = Modifier
//
//                            .padding(20.dp),
//                        horizontalAlignment = Alignment.Start,
//                        verticalArrangement = Arrangement.Top
//                    )
//                    {
//                        LocationAndDate(data = weather)
//                        WeatherInfo(data = weather)
//                    }
//                }
//                else {
//                    Row(
//                        modifier = Modifier
//
//                            .padding(20.dp),
//                        horizontalArrangement = Arrangement.End,
//                        verticalAlignment = Alignment.Bottom
//                    ) {
//                        LocationAndDate(data = weather)
//                        WeatherInfo(data = weather)
//                    }
//                }
//


            RectangleSection(listWeatherCharData = listWeatherCharData)
            SunRiseSet(data = weather)
            AllDayWeather(list = listDayWiseData, navController = navController)

        }
    }
}

@Composable
fun ShowDropDownMenu(
    expandedDropDown: MutableState<Boolean>,
    navController: NavController,
    openDialog: MutableState<Boolean>
) {
    val list = listOf("Favorites", "About", "Settings")
    var expanded = remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .background(Color.Black)
            .fillMaxWidth()
            .wrapContentSize(Alignment.TopEnd)
            .absolutePadding(top = 45.dp, right = 20.dp),
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Top
    ) {

        DropdownMenu(
            expanded = expandedDropDown.value,
            onDismissRequest = { expandedDropDown.value = false }) {

            DropdownMenuItem(onClick = { expandedDropDown.value = false }
            ) {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = "Localized description",
                    tint = Color.White
                )
                Text(
                    text = list[0],
                    color = Color.White,
                    fontStyle = FontStyle.Normal,

                    fontFamily = fontFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 12.sp
                )

            }
            DropdownMenuItem(onClick = {
                openDialog.value = true
                expandedDropDown.value = false
            }) {
                Icon(
                    Icons.Filled.Info,
                    contentDescription = "Localized description",
                    tint = Color.White
                )
                Text(
                    text = list[1],
                    color = Color.White,
                    fontStyle = FontStyle.Normal,

                    fontFamily = fontFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 12.sp
                )
            }
            DropdownMenuItem(onClick = {
                navController.navigate(Screens.SettingsPage.name)
                expandedDropDown.value = false
            }

            ) {
                Icon(
                    Icons.Filled.Settings,
                    contentDescription = "Localized description",
                    tint = Color.White
                )
                Text(
                    text = list[2],
                    color = Color.White,
                    fontStyle = FontStyle.Normal,

                    fontFamily = fontFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 12.sp
                )

            }
        }
    }
}

