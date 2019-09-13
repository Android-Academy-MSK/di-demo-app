package ru.ftc.todoapp.app

import android.app.Application
import ru.ftc.todoapp.data.Storage
import ru.ftc.todoapp.data.StorageImpl
import ru.ftc.todoapp.feature.login.data.LoginRepositoryImpl
import ru.ftc.todoapp.feature.login.domain.*
import ru.ftc.todoapp.feature.task.data.TaskRepositoryImpl
import ru.ftc.todoapp.feature.task.domain.*
import ru.ftc.todoapp.navigation.Router
import ru.ftc.todoapp.navigation.RouterImpl

class App : Application() {

    companion object {
        private lateinit var storage: Storage

        private lateinit var taskRepository: TaskRepository
        private lateinit var loginRepository: LoginRepository

        lateinit var isLoggedInUseCase: IsLoggedInUseCase
        lateinit var loginUseCase: LoginUseCase
        lateinit var logoutUseCase: LogoutUseCase

        lateinit var getTasksUseCase: GetTasksUseCase
        lateinit var createTaskUseCase: CreateTaskUseCase
        lateinit var deleteTaskUseCase: DeleteTaskUseCase
        lateinit var updateTaskUseCase: UpdateTaskUseCase

        val router: Router = RouterImpl()
    }

    override fun onCreate() {
        super.onCreate()

        storage = StorageImpl(this)

        taskRepository = TaskRepositoryImpl(storage)
        loginRepository = LoginRepositoryImpl(storage)

        isLoggedInUseCase = IsLoggedInUseCaseImpl(loginRepository)
        loginUseCase = LoginUseCaseImpl(loginRepository)
        logoutUseCase = LogoutUseCaseImpl(loginRepository)

        getTasksUseCase = GetTasksUseCaseImpl(taskRepository)
        createTaskUseCase = CreateTaskUseCaseImpl(taskRepository)
        deleteTaskUseCase = DeleteTaskUseCaseImpl(taskRepository)
        updateTaskUseCase = UpdateTaskUseCaseImpl(taskRepository)
    }
}