package com.example.navigation2025.model

import java.net.URLEncoder

//es una clase que permite restringir la jerarquía de clases heredadas.
// Es útil para representar un conjunto fijo de tipos relacionados
// que comparten un contexto común.
// A menudo se utiliza en patrones como modelar estados,
// eventos, o resultados,
// donde sabes de antemano todas las posibles subclases que pueden existir.
sealed class Routes(val route:String) {
    object Screen01:Routes("Pantalla1")
    object Screen02:Routes("Pantalla2")
    object Screen03:Routes("Pantalla3")
    object Screen04:Routes("Pantalla4/{name}")
    fun createRouteScreen04(name: String): String {
        return "Pantalla4/${URLEncoder.encode(name, "UTF-8")}"
    }
}