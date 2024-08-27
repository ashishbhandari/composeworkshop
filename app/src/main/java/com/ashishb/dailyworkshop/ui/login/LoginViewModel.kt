package com.ashishb.dailyworkshop.ui.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.getAndUpdate

// Controlling UI States with ViewModel
class LoginViewModel : ViewModel() {

    //Login UI State

    // Backing property to avoid state updates from other classes
    private val _loginUiState = MutableStateFlow(LoginUiState())

    //The asStateFlow() makes this mutable state flow a read-only state flow.
    val loginUiState: StateFlow<LoginUiState> = _loginUiState.asStateFlow()


    // Number of attempts used for the login
    private var usedAttempts: Int = 0

    // Set of inputs used in the Login screen
    var userEmail by mutableStateOf("")
    var userPassword by mutableStateOf("")

    fun validateLogin() {
        if (userEmail.equals("abc", ignoreCase = true)
            && userPassword.equals("abc", ignoreCase = true)
        ) {
            // User's credentials correct, show him new screen

        } else {
            // Show error message ion screen
            _loginUiState.getAndUpdate {currentState -->

            }

        }

    }

}