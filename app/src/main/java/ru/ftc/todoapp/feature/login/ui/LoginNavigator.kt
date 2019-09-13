package ru.ftc.todoapp.feature.login.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import ru.ftc.todoapp.feature.main.MainActivity
import ru.ftc.todoapp.navigation.Destination
import ru.ftc.todoapp.navigation.Navigator

class LoginNavigator(private val activity: AppCompatActivity) : Navigator {

    override fun navigateTo(destination: Destination) {
        when (destination) {

            Destination.TaskList -> {
                activity.startActivity(Intent(activity.application, MainActivity::class.java))
                activity.finish()
            }

            Destination.Back -> {
                activity.onBackPressed()
            }

            else -> {
                throw IllegalArgumentException("cannot navigate to $destination")
            }
        }
    }
}