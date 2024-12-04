package com.example.seneca

import android.content.Context
import android.location.Location
import android.location.LocationManager
import android.location.provider.ProviderProperties
import android.os.Bundle

fun setMockLocation(context: Context, latitude: Double, longitude: Double, altitude: Double = 0.0) {
    val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    val providerName = LocationManager.GPS_PROVIDER

    // En lugar de verificar el proveedor, se configura directamente el mockLocation
    // Se asume que el proveedor ya está habilitado y configurado en las opciones de desarrollador

    // Crea una ubicación simulada
    val mockLocation = Location(providerName).apply {
        this.latitude = latitude
        this.longitude = longitude
        this.altitude = altitude
        this.time = System.currentTimeMillis()  // Usa el tiempo actual
        this.accuracy = 5.0f                   // Establece la precisión de la ubicación
        this.elapsedRealtimeNanos = System.nanoTime() // Tiempo de referencia en nanosegundos
    }

    // Si tienes permisos y la configuración correcta, puedes usar esto
    locationManager.setTestProviderLocation(providerName, mockLocation)
}