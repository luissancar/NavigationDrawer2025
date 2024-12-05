package com.example.navigation2025.model

//es una clase que permite restringir la jerarquía de clases heredadas.
// Es útil para representar un conjunto fijo de tipos relacionados que comparten un contexto común.
// A menudo se utiliza en patrones como modelar estados, eventos, o resultados,
// donde sabes de antemano todas las posibles subclases que pueden existir.
sealed class Routes(val route:String) {
    object Screen01:Routes("Pantalla1")
    object Screen02:Routes("Pantalla2")
    object Screen03:Routes("Pantalla3")
}