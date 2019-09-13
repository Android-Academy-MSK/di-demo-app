package ru.ftc.todoapp.feature.login.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.ftc.todoapp.R
import ru.ftc.todoapp.app.App

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_frame)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.content_frame, LoginFragment.newInstance())
                .commit()
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        App.router.setNavigator(LoginNavigator(this))
    }

    override fun onPause() {
        super.onPause()
        App.router.setNavigator(null)
    }
}