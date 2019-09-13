package ru.ftc.todoapp.feature.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.ftc.todoapp.R
import ru.ftc.todoapp.app.App
import ru.ftc.todoapp.feature.task.ui.TaskListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_frame)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.content_frame, TaskListFragment.newInstance())
                .commit()
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        App.router.setNavigator(MainNavigator(this))
    }

    override fun onPause() {
        super.onPause()
        App.router.setNavigator(null)
    }
}