package net.celesoft.reverse.ctf.login.service

class FakeLoginService : LoginService {

    override fun login(login: String, password: String): String? =
        if (hasCredentials(login, password)) "token"
        else null

    private fun hasCredentials(login: String, password: String): Boolean =
        "$login$password".hashCode() == 130581930

}