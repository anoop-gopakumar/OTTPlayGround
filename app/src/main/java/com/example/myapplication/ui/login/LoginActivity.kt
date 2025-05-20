package com.example.myapplication.ui.login

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.ActivityLoginBinding
import com.example.myapplication.ui.BaseActivity
import com.example.myapplication.ui.dashboard.DashboardViewModel
import com.example.myapplication.ui.dashboard.intent.LoginIntent
import com.example.myapplication.ui.dashboard.viewmodel.LoginViewModel
import com.example.myapplication.ui.main.MainActivity
import com.example.myapplication.utils.ActLauncher
import com.example.myapplication.utils.programs.BaseSort

class LoginActivity : BaseActivity<ActivityLoginBinding>() {

    lateinit var sort: BaseSort
    lateinit var actLauncher: ActLauncher

    override fun  getViewBinding(): ActivityLoginBinding {
        return ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        actLauncher = ActLauncher()

        loadLoginTemplate()

        inlineFunc {
            Log.d("DashBoardFragment", "Calling inline function")
        }

    }

    private fun loadLoginTemplate() {
        val loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        val dashboardViewModel =
            ViewModelProvider(this)[DashboardViewModel::class.java]

        binding?.buttonLogin?.setOnClickListener {
            moveToMain()
            loginViewModel.processIntent(LoginIntent.LoadData)
        }

        val textView: TextView = binding?.loginText!!
        dashboardViewModel.text.observe(this) {
            textView.text = it
        }

        loginViewModel.state.observe(this) { state ->
            when {
                state.isLoading -> {
                    showLoader()
                }

                state.error != null -> {
                    showError();
                }

                state.data != null -> {
                    showData();
                }
            }
        }
    }

    private fun showLoader() {

    }

    private fun showError() {

    }

    private fun showData() {

    }

    private fun moveToMain() {
        actLauncher.launchAct(this@LoginActivity, MainActivity::class.java)
    }

    private inline fun inlineFunc(callBack: (value: String) -> Any) {
        callBack("")
        Log.d("DashBoardFragment", "Inside of inlineFunc: ")
    }

    inline fun <reified T> checkType(value: Any) {
        if (value is T) {
            println("The value is of type T")
        } else {
            println("The value is not of type T")
        }
    }

}