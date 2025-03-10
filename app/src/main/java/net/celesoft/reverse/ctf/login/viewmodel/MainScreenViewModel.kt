package net.celesoft.reverse.ctf.login.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import net.celesoft.reverse.ctf.login.service.LoginService

class MainScreenViewModel(
    private val loginService: LoginService
) : MainViewModel {

    override val login: MutableState<String> = mutableStateOf("")
    override val password: MutableState<String> = mutableStateOf("")
    override val errorVisibility: MutableState<Boolean> = mutableStateOf(false)
    override val hasCredentials: MutableState<Boolean> = mutableStateOf(false)

    override fun onResume() {
        login.value = ""
        password.value = ""
        hasCredentials.value = false
    }

    override fun onLoginChanged(login: String) {
        this.login.value = login
    }

    override fun onPasswordChanged(password: String) {
        this.password.value = password
    }

    override fun onLogInClicked() {
        processLogin()
    }

    private fun processLogin() {
        val token = loginService.login(login.value, password.value)
        errorVisibility.value = hasToken(token).not()
        hasCredentials.value = hasToken(token)
    }

    private fun hasToken(token: String?) = token != null

}