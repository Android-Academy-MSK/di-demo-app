package ru.ftc.todoapp.navigation

import ru.ftc.todoapp.feature.task.domain.entity.Task

sealed class Destination {

    object Back : Destination()

    object NewTask : Destination()

    object TaskList : Destination()

    object Login : Destination()

    data class EditTask(val task: Task) : Destination()
}