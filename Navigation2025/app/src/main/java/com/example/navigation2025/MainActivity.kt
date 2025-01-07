package com.example.navigation2025

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigation2025.ui.theme.Navigation2025Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Navigation2025Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                  /*  Nav01(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )*/

                  /*  Nav02(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding))*/

                    Nav04(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

