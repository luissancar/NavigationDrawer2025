package com.example.mvvm2025.login

import android.util.Patterns
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Lock
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class LoginViewModel : ViewModel() {
    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email


    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password


    private val _isLoginEnable = MutableLiveData<Boolean>()
    val isLoginEnable: LiveData<Boolean> = _isLoginEnable

    private val _isPasswordVisible = MutableLiveData<Boolean>()
    val isPasswordVisible: LiveData<Boolean> = _isPasswordVisible

    fun onLoginChanged(email: String, password: String) {
        _email.value = email
        _password.value = password
        _isLoginEnable.value = enableLogin(email, password)
    }


    fun enableLogin(email: String, password: String) =
        Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length > 6

    fun changePasswordVisible() {
        if (_isPasswordVisible.value == true)
            _isPasswordVisible.value = false
        else
            _isPasswordVisible.value = true
    }


    fun changeVisualTransformation(isPasswordVisible: Boolean): VisualTransformation {
        if (isPasswordVisible)
            return VisualTransformation.None
        else
            return PasswordVisualTransformation()
    }

    fun changeImageVector(): ImageVector {
        if (_isPasswordVisible.value == true)
            return Icons.Default.Edit
        else
            return Icons.Default.Lock
    }

    fun contentDescription(): String{

            if (_isPasswordVisible.value == true)
                return "Hide password"
            else
                return "Show password"

    }

}