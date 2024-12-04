package com.example.navigationdrawer2025

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModalDrawerExample() {
    // Controlador del estado del Drawer
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            // Contenido del drawer
            DrawerContent()
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Modal Drawer Example") },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                if (drawerState.isClosed) {
                                    drawerState.open() // Abre el drawer
                                } else {
                                    drawerState.close() // Cierra el drawer
                                }
                            }
                        }) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu")
                        }
                    }
                )
            },
            modifier = Modifier.fillMaxSize() // El contenido principal ocupa toda la pantalla
        ) { innerPadding ->
            // Usa innerPadding para asegurar que el contenido no esté cubierto
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding), // Usa el innerPadding para asegurar que el contenido no esté cubierto
                contentAlignment = Alignment.Center
            ) {
                Text("Contenido principal")
            }
        }
    }
}

@Composable
fun DrawerContent() {
    // Define el contenido del drawer
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 70.dp) // Ajusta este padding si la TopAppBar tiene diferente altura
    ) {
        Text(text = "Opción 1", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Opción 2", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Opción 3", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(8.dp))

        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Configuración", style = MaterialTheme.typography.bodyLarge)
    }
}
