package net.celesoft.reverse.ctf.login.service

interface LoginService {

    fun login(login: String, password: String): String?

}