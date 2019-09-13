package ru.ftc.todoapp.feature.login.domain

interface LoginRepository {

    fun isLoggedIn(): Boolean

    fun login(name: String, password: String): Boolean

    fun logout()
}
