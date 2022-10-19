package com.example.septemberproject24

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.septemberproject24.navigation.Screens
import com.example.septemberproject24.presentation.screens.*

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.SplashScreen.name ) {
        composable(Screens.SplashScreen.name){
            SplashScreen(navController = navController)
        }
        composable(Screens.DetailsScreen.name){
            DetailsScreen(navController = navController)
        }
        composable(Screens.SettingsPage.name) {
            SettingsPage(navController = navController)
        }
        composable(Screens.SearchScreen.name) {
           SearchScreen(navController = navController)
        }

        val route = Screens.MainScreen.name
        composable("$route/{city}",
        arguments = listOf(
            navArgument(name = "city"){
                type = NavType.StringType
            }
        )) {
            navBack ->
            navBack.arguments?.getString("city").let { city->
                val mainViewModel = hiltViewModel<MainViewModel>()
                MainScreen(navController = navController, mainViewModel = mainViewModel, city = city)
            }

        }

    }
}



