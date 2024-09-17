package com.ashishb.dailyworkshop.ui.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

// Controlling UI States with ViewModel
class LoginViewModel : ViewModel() {

    //Login UI State

    // Backing property to avoid state updates from other classes
    private val _loginUiState = MutableStateFlow(LoginUiState())

    //The asStateFlow() makes this mutable state flow a read-only state flow.
    val loginUiState: StateFlow<LoginUiState> = _loginUiState.asStateFlow()


    // refrence: https://developer.android.com/develop/ui/compose/text/user-input

    // Number of attempts used for the login
    private var usedAttempts: Int = 0

    // Set of inputs used in the Login screen
    //Use MutableState to represent TextField state: Avoid using reactive streams like StateFlow to represent TextField state, as these structures might introduce asynchronous delays.
    var userEmail by mutableStateOf("")
        private set
    var userPassword by mutableStateOf("")
        private set

    var isRememberMe by mutableStateOf(false)
        private set

    //Avoid delays to update the state: When you call onValueChange, update your TextField synchronously and immediately:
    fun updateUserEmail(userInputEmail: String) {
        userEmail = userInputEmail
    }

    fun updateUserPassword(userInputPassword: String) {
        userPassword = userInputPassword
    }

    fun validateLogin() {
        if (userEmail.equals("abc", ignoreCase = true)
            && userPassword.equals("abc", ignoreCase = true)
        ) {
            // User's credentials correct, show him new screen

        } else {
            // Show error message on screen
            _loginUiState.update { currentState ->
                currentState.copy(isLoggedInSuccessFully = false)
            }
        }
        //reset the state if required
    }

    fun validatePasswordField() {

    }

    fun updateRememberMe() {
        _loginUiState.update {currentState ->
            currentState.copy(
                isLoggedInSuccessFully = !currentState.isLoggedInSuccessFully
            )
        }
    }

}