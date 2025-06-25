package com.ott.ottapplication.ui.login

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.ott.ottapplication.ui.BaseActivity
import com.ott.ottapplication.ui.dashboard.viewmodel.LoginViewModel
import com.ott.ottapplication.ui.main.MainActivity
import com.ott.ottapplication.utils.ActivityLauncher
import com.ott.ottapplication.databinding.ActivityLoginBinding
import com.ott.ottapplication.network.response.LoginResponse
import com.ott.ottapplication.ui.dashboard.viewmodel.LoginStates
import com.ott.ottapplication.ui.widget.Extension.setCustomVisibility
import java.util.regex.Pattern

class LoginActivity : BaseActivity<ActivityLoginBinding>() {

    private lateinit var activityLauncher: ActivityLauncher
    private lateinit var loginViewModel: LoginViewModel

    override fun getViewBinding(): ActivityLoginBinding {
        return ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityLauncher = ActivityLauncher()
        loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        setDummyText()
        registerFirebaseAuth()
        registerListeners()
        handleLogin()

    }

    private fun setDummyText() {
        binding?.editTextEmail?.setText("eve.holt@reqres.in")
        binding?.editTextPassword?.setText("pistol")
    }

    private fun registerFirebaseAuth() {
        registerForActivityResult(FirebaseAuthUIActivityResultContract()) { res ->
            Log.d("TAG", "registerFirebaseAuth: ")
        }
    }

    private fun registerListeners() {
        binding?.buttonLogin?.setOnClickListener {

            val email = binding?.editTextEmail?.text.toString()
            val password = binding?.editTextPassword?.text.toString()

            if (validateEmailAndPassword(email, password)) {
                loginViewModel.processLogin(email, password)
            } else {
                showMessage("Email or password is invalid")
            }
        }
        binding?.skipSignIn?.setOnClickListener {
            moveToMain()
        }
        binding?.forgotPassword?.setOnClickListener {
            showMessage("Feature is on development")
        }
        binding?.dontHaveAccount?.setOnClickListener {
            showMessage("Feature is on development")
        }
    }

    private fun handleLogin() {
        loginViewModel.state.observe(this) { state ->
            when (state) {
                is LoginStates.LoadingStatus -> {
                    showLoader(state.isLoading)
                }
                is LoginStates.LoginResponses -> {
                    showData(state.responses)
                }
                is LoginStates.ErrorMessage -> {
                    showError(state.message)
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
        return if (password.isNotEmpty()) {
            password.length >= 4
        } else {
            true
        }
    }

    private fun moveToMain() {
        activityLauncher.launchAct(this@LoginActivity, MainActivity::class.java)
    }

    private fun showLoader(isLoading: Boolean) {
        binding?.pgBar?.setCustomVisibility(isLoading)
    }

    private fun showError(message: String) {
        showMessage(message)
    }

    private fun showData(token: LoginResponse?) {
        Log.d("TAG", "token is : ${token?.token}")
        // Save token to db and move to main
        moveToMain()
    }

}