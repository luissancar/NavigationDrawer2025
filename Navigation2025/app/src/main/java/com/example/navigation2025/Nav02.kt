package com.example.navigation2025

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigation2025.model.Routes


@Composable
fun Nav02(name: String, modifier: Modifier = Modifier) {
    val navigationController = rememberNavController()
    NavHost(navController = navigationController, startDestination = Routes.Screen01.route) {
        composable(route = Routes.Screen01.route) { Pantalla01(navController = navigationController) }
        composable(route = Routes.Screen02.route) { Pantalla02(navController = navigationController) }
        composable(route = Routes.Screen03.route) { Pantalla03(navController = navigationController) }
    }
}