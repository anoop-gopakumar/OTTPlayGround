package com.ott.ottapplication.ui.login

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.ott.ottapplication.ui.BaseActivity
import com.ott.ottapplication.ui.dashboard.viewmodel.LoginViewModel
import com.ott.ottapplication.ui.main.MainActivity
import com.example.ottapplication.utils.ActivityLauncher
import com.ott.ottapplication.databinding.ActivityLoginBinding
import java.util.regex.Pattern

class LoginActivity : BaseActivity<ActivityLoginBinding>() {

    lateinit var activityLauncher: ActivityLauncher
    lateinit var loginViewModel: LoginViewModel

    override fun getViewBinding(): ActivityLoginBinding {
        return ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityLauncher = ActivityLauncher()
        loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        registerListeners()
        handleLogin()

    }

    private fun registerListeners() {
        binding?.buttonLogin?.setOnClickListener {

            val email = binding?.editTextEmail?.text.toString()
            val password = binding?.editTextPassword?.text.toString()

            if (validateEmailAndPassword(email, password)) {
                loginViewModel.processLogin(email, password)
            } else {
                showSnackBar("Email or password is invalid")
            }

        }
        binding?.skipSignIn?.setOnClickListener {

            moveToMain()

        }
        binding?.forgotPassword?.setOnClickListener {

            showSnackBar("Feature is on development")

        }
        binding?.dontHaveAccount?.setOnClickListener {

            showSnackBar("Feature is on development")

        }
    }

    private fun handleLogin() {

        loginViewModel.state.observe(this) { state ->
            when {
                state.isLoading -> {
                    showLoader()
                }

                state.error != null -> {
                    showError()
                }

                state.data != null -> {
                    showData()
                }
            }
        }
    }

    private fun validateEmailAndPassword(email: String, password: String): Boolean {
        return validateEmail(email) && validatePassword(password)
    }

    private fun validateEmail(email: String): Boolean {
        if (email.isNotEmpty()) {
            val pattern = Pattern.compile(".+@.+\\.[a-z]+")
            val matcher = pattern.matcher(email)
            return matcher.matches()
        } else {
            return false
        }
    }

    private fun validatePassword(password: String): Boolean {
        if (password.isNotEmpty()) {
            if (password.length < 6) return false
            if (password.firstOrNull { it.isDigit() } == null) return false
        } else {
            return true
        }
        return false
    }

    private fun moveToMain() {
        activityLauncher.launchAct(this@LoginActivity, MainActivity::class.java)
    }

    private fun showLoader() {

    }

    private fun showError() {

    }

    private fun showData() {

    }


}