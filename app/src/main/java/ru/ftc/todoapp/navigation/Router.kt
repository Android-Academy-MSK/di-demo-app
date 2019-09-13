package ru.ftc.todoapp.navigation

interface Router {

    fun goto(destination: Destination)

    fun setNavigator(navigator: Navigator?)
}