package ru.ftc.todoapp.feature.login.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.toolbar_dark.*
import ru.ftc.todoapp.R
import ru.ftc.todoapp.app.App
import ru.ftc.todoapp.feature.login.presentation.LoginPresenter
import ru.ftc.todoapp.feature.login.presentation.LoginPresenterImpl
import ru.ftc.todoapp.feature.login.presentation.LoginView

class LoginFragment : Fragment(), LoginView {

    companion object {

        fun newInstance(): Fragment =
            LoginFragment()
    }

    private lateinit var presenter: LoginPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_login, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbar.title = getString(R.string.login)

        presenter = LoginPresenterImpl(
            loginUseCase = App.loginUseCase,
            isLoggedInUseCase = App.isLoggedInUseCase,
            router = App.router
        )
        presenter.attachView(this)

        login_enter.setOnClickListener {
            presenter.onLoginClick(
                login_name.text.toString(),
                login_password.text.toString()
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detachView()
    }

    override fun showError() {
        login_password.error = getString(R.string.login_error)
    }
}