package ru.ftc.todoapp.feature.login.domain

interface LoginUseCase {

    operator fun invoke(name: String, password: String): Boolean
}

class LoginUseCaseImpl(
    private val loginRepository: LoginRepository
): LoginUseCase {

    override fun invoke(name: String, password: String): Boolean =
        loginRepository.login(name, password)
}