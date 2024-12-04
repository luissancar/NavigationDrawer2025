package com.example.seneca

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityCompat.*
import androidx.core.content.ContextCompat


private const val LOCATION_PERMISSION_REQUEST_CODE = 1001

// Composable principal
@Composable
fun Seneca(modifier: Modifier) {
    // Obtener el contexto dentro del composable
    val context = LocalContext.current

    Column(modifier = modifier.fillMaxSize()) {
        Button(onClick = {
            // Llamar a la función que simula la ubicación
            simulateLocation(context = context)
        }) {
            Text("Pulsar")
        }
    }
}

// Llamada que maneja la lógica de simulación de ubicación

fun simulateLocation(context: Context) {
    // Usamos LaunchedEffect para asegurarnos de que las tareas se ejecuten en el hilo principal

    val latitude = 37.7749  // Ejemplo de latitud (San Francisco)
    val longitude = -122.4194  // Ejemplo de longitud (San Francisco)
    val altitude = 10.0  // Altitud simulada en metros

    // Llamamos a la función que maneja la ubicación
    checkLocationPermission(context)
    setMockLocation(context, latitude, longitude, altitude)

    // Mostrar un Toast para notificar que la ubicación ha sido simulada
    Toast.makeText(context, "Ubicación simulada: ($latitude, $longitude)", Toast.LENGTH_SHORT)
        .show()

}


private fun checkLocationPermission(context: Context) {

    val permission = android.Manifest.permission.ACCESS_FINE_LOCATION
    if (ContextCompat.checkSelfPermission(
            context,
            permission
        ) != PackageManager.PERMISSION_GRANTED
    ) {
        requestPermissions(
            (context as Activity),
            arrayOf(permission),
            LOCATION_PERMISSION_REQUEST_CODE
        )
    }
}