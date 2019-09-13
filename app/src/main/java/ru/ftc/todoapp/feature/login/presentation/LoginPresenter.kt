package ru.ftc.todoapp.feature.login.presentation

import ru.ftc.todoapp.feature.login.domain.IsLoggedInUseCase
import ru.ftc.todoapp.feature.login.domain.LoginUseCase
import ru.ftc.todoapp.feature.task.domain.DeleteTaskUseCase
import ru.ftc.todoapp.feature.task.domain.GetTasksUseCase
import ru.ftc.todoapp.feature.task.domain.entity.Task
import ru.ftc.todoapp.mvp.Presenter
import ru.ftc.todoapp.navigation.Destination
import ru.ftc.todoapp.navigation.Router

abstract class LoginPresenter: Presenter<LoginView>() {

    abstract fun onLoginClick(name: String, password: String)
}

class LoginPresenterImpl(
    private val loginUseCase: LoginUseCase,
    private val isLoggedInUseCase: IsLoggedInUseCase,
    private val router: Router
): LoginPresenter() {

    override fun onViewAttach() {
        if (isLoggedInUseCase()) {
            router.goto(Destination.TaskList)
        }
    }

    override fun onLoginClick(name: String, password: String) {
        if (loginUseCase(name, password)) {
            router.goto(Destination.TaskList)
        } else {
            view?.showError()
        }
    }
}