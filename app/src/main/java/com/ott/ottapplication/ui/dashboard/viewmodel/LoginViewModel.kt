package com.ott.ottapplication.ui.dashboard.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ott.ottapplication.ui.dashboard.LoginState
import com.ott.ottapplication.usecase.LoginRepository
import com.ott.ottapplication.usecase.LoginUseCaseImpl

class LoginViewModel : ViewModel() {

    private val _state = MutableLiveData<LoginState>()

    val state: LiveData<LoginState> = _state;


    fun processLogin(userName: String, password: String) {
        val useCase = LoginUseCaseImpl(LoginRepository())
        useCase.login(userName, password)
    }


}