package ru.ftc.todoapp.feature.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import ru.ftc.todoapp.R
import ru.ftc.todoapp.feature.login.ui.LoginActivity
import ru.ftc.todoapp.feature.task.ui.TaskFragment
import ru.ftc.todoapp.navigation.Destination
import ru.ftc.todoapp.navigation.Navigator

class MainNavigator(private val activity: AppCompatActivity) : Navigator {

    override fun navigateTo(destination: Destination) {
        if (destination == Destination.Login) {
            activity.startActivity(Intent(activity, LoginActivity::class.java))
            activity.finish()
            return
        }

        val newFragment = when (destination) {

            Destination.NewTask -> {
                TaskFragment.newInstance(null)
            }

            is Destination.EditTask -> {
                TaskFragment.newInstance(destination.task)
            }

            Destination.Back -> {
                null
            }

            else -> {
                throw IllegalArgumentException("cannot navigate to $destination")
            }
        }

        if (newFragment == null) {
            if (activity.supportFragmentManager.backStackEntryCount > 1) {
                activity.supportFragmentManager.popBackStack()
            } else {
                activity.onBackPressed()
            }
        } else {
            activity.supportFragmentManager.beginTransaction()
                .replace(R.id.content_frame, newFragment)
                .addToBackStack(null)
                .commit()
        }
    }
}