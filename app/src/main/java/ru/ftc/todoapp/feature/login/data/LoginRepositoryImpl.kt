package ru.ftc.todoapp.feature.login.data

import ru.ftc.todoapp.data.Storage
import ru.ftc.todoapp.feature.login.domain.LoginRepository

class LoginRepositoryImpl(private val storage: Storage) : LoginRepository {

    private companion object {
        const val LOGGED_IN_KEY = "LOGGED_IN_KEY"
        const val LOGGED_IN = "LOGGED_IN"
    }

    override fun isLoggedIn(): Boolean =
        storage[LOGGED_IN_KEY] == LOGGED_IN

    override fun login(name: String, password: String): Boolean {
        val loggedIn = name == "1" && password == "1"
        storage[LOGGED_IN_KEY] = if (loggedIn) LOGGED_IN else null
        return loggedIn
    }

    override fun logout() {
        storage[LOGGED_IN_KEY] = null
    }
}