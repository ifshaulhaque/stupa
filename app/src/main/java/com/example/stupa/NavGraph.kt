package com.example.stupa

import androidx.annotation.Keep
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.stupa.screens.registration.RegistrationScreen

@Composable
fun NavGraph(
  navController: NavHostController = rememberNavController()
) {
  NavHost(
    navController = navController,
    startDestination = RoutePath.RegistrationScreen.route
  ) {
    setComposable(
      route = RoutePath.RegistrationScreen.route
    ) {
      RegistrationScreen(navController = navController)
    }
  }
}

@Keep
open class RoutePath(val route: String) {
  data object RegistrationScreen: RoutePath("RegistrationScreen")
}