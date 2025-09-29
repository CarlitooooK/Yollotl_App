package com.example.yollotl_app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.yollotl_app.MainScreen
import com.example.yollotl_app.SplashScreen


@Composable
fun AppNavigation() {

    val navController = rememberNavController()
    NavHost(navController, AppScreens.SplashScreen.route) {
        composable(AppScreens.SplashScreen.route){
            SplashScreen(navController)
        }
        composable(AppScreens.MainScreen.route) {
            MainScreen()
        }

    }
}