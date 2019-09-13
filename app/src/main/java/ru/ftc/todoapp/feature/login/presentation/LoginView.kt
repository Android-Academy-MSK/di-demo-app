package ru.ftc.todoapp.feature.login.presentation

import ru.ftc.todoapp.feature.task.domain.entity.Task
import ru.ftc.todoapp.mvp.View

interface LoginView: View {

    fun showError()
}