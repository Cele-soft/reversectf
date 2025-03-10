package net.celesoft.reverse.ctf.login.viewmodel

import androidx.compose.runtime.State

interface MainViewModel {

    val login: State<String>
    val password: State<String>
    val errorVisibility: State<Boolean>
    val hasCredentials: State<Boolean>

    fun onResume()
    fun onLoginChanged(login: String)
    fun onPasswordChanged(password: String)
    fun onLogInClicked()
}