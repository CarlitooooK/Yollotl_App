package com.example.yollotl_app.navigation

sealed class AppScreens(val route:String) {
    object SplashScreen: AppScreens("splash_screen")
    object MainScreen: AppScreens("main_screen")

    object StartScreen: AppScreens("start_screen")
}