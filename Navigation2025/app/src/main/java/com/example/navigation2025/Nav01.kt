package com.example.navigation2025

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun Nav01(name: String, modifier: Modifier = Modifier) {
    val navigationController = rememberNavController()
    NavHost(navController = navigationController, startDestination = "Screen01") {
        composable(route = "Screen01") { Pantalla01(navController = navigationController) }
        composable(route = "Screen02") { Pantalla02(navController = navigationController) }
        composable(route = "Screen03") { Pantalla03(navController = navigationController) }
    }
}