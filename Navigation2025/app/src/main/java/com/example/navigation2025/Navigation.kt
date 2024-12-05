package com.example.navigation2025

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.navigation2025.model.Routes

@Composable
fun Pantalla01(navController: NavHostController) {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {
        Text(
            text = "Pantalla 01",
            modifier = Modifier
                .align(Alignment.Center)
                //  .clickable { navController.navigate("Screen02") }
                .clickable { navController.navigate(Routes.Screen02.route) }

        )
    }
}


@Composable
fun Pantalla02(navController: NavHostController) {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.Blue)
    ) {
        Text(
            text = "Pantalla 02",
            modifier = Modifier
                .align(Alignment.Center)
                //.clickable { navController.navigate("Screen03") }
                .clickable { navController.navigate(Routes.Screen03.route) }

        )
    }
}


@Composable
fun Pantalla03(navController: NavHostController) {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.Green)
    ) {
        Text(
            text = "Pantalla 03",
            modifier = Modifier
                .align(Alignment.Center)
                // .clickable { navController.navigate("Screen01") }
                .clickable { navController.navigate(Routes.Screen01.route) }
        )
    }
}