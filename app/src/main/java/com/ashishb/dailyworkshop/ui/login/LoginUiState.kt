package com.ashishb.dailyworkshop.ui.login

data class LoginUiState(
    val userName: String? = null,
    val password: String? = null,
    val rememberMe: Boolean = false,
    val isLoggedInSuccessFully: Boolean = false,
)
