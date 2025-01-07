package com.example.navigation2025

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navigation2025.model.Routes


@Composable
fun Nav04(name: String, modifier: Modifier = Modifier) {
    val navigationController = rememberNavController()
    NavHost(navController = navigationController, startDestination = Routes.Screen01.route) {
        composable(route = Routes.Screen01.route) { Pantalla01(navController = navigationController) }
        composable(route = Routes.Screen02.route) { Pantalla02(navController = navigationController) }
        composable(route = Routes.Screen03.route) { Pantalla03(navController = navigationController) }
        composable(
            route = Routes.Screen04.route,
            arguments = listOf(navArgument("name") {
                type = NavType.StringType })
        ) { backStackEntry ->
            Pantalla04(
                navController = navigationController,
                backStackEntry.arguments?.getString("name") ?: ""
            )
        }
    }
}