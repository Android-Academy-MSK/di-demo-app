package ru.ftc.todoapp.feature.task.data

import com.google.gson.Gson
import ru.ftc.todoapp.data.Storage
import ru.ftc.todoapp.feature.task.domain.TaskRepository
import ru.ftc.todoapp.feature.task.domain.entity.Task

class TaskRepositoryImpl(
    private val storage: Storage
) : TaskRepository {

    private companion object {

        const val TASKS_KEY = "TASKS_KEY"
    }

    private val gson = Gson()

    override fun get(): List<Task> =
        gson.fromJson(storage[TASKS_KEY], Array<Task>::class.java)?.toList() ?: listOf()

    override fun add(task: Task) {
        val tasks = get().toMutableList()
        tasks.add(task)
        storage[TASKS_KEY] = gson.toJson(tasks.toTypedArray())
    }

    override fun update(task: Task) {
        val tasks = get().toMutableList()
        val position = tasks.indexOfFirst { it.id == task.id }
        tasks[position] = task
        storage[TASKS_KEY] = gson.toJson(tasks.toTypedArray())
    }

    override fun delete(task: Task) {
        val tasks = get().toMutableList()
        tasks.remove(task)
        storage[TASKS_KEY] = gson.toJson(tasks.toTypedArray())
    }
}