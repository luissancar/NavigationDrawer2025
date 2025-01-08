package com.example.mvvm2025.login


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen2(loginViewModel: LoginViewModel) {
    val email:String by loginViewModel.email.observeAsState("")
   // var email by remember { mutableStateOf("") }
    val password:String by loginViewModel.password.observeAsState("")
   // var password by remember { mutableStateOf("") }
    var passwordVisible: Boolean by remember { mutableStateOf(false) }

    val isPasswordVisible:Boolean by loginViewModel.isPasswordVisible.observeAsState(false)


    val isLoginEnable:Boolean by loginViewModel.isLoginEnable.observeAsState(false)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        // Campo de texto para el email
        OutlinedTextField(
            value = email,
            onValueChange = {
                // email = it
                loginViewModel.onLoginChanged(it,password)
                            },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Campo de texto para la contraseña
        OutlinedTextField(
            value = password,
            onValueChange = { loginViewModel.onLoginChanged(email,it) },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            visualTransformation = loginViewModel.changeVisualTransformation(isPasswordVisible),
            //if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { loginViewModel.changePasswordVisible() }) {
                    Icon(
                        imageVector = loginViewModel.changeImageVector(),
                        contentDescription = loginViewModel.contentDescription()
                    )
                }
            }
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Botón que no hace nada
        Button(
            onClick = { /* Por ahora no hace nada */ },
            modifier = Modifier.fillMaxWidth(),
            enabled = isLoginEnable
        ) {
            Text("Login")
        }
       // Text(text = isPasswordVisible.toString())
    }
}
