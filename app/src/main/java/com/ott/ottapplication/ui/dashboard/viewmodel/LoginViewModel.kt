package com.ott.ottapplication.ui.dashboard.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ott.ottapplication.network.response.LoginResponse
import com.ott.ottapplication.network.LoginRepository
import com.ott.ottapplication.usecase.LoginUseCaseImpl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val _state = MutableLiveData<LoginStates>()

    val state: LiveData<LoginStates> = _state

    private val scope = CoroutineScope(Dispatchers.IO)

    fun processLogin(userName: String, password: String) {

        val useCase = LoginUseCaseImpl(LoginRepository())
        _state.value = LoginStates.LoadingStatus(true)

        scope.launch {
            val result = useCase.login(userName, password)
            _state.postValue(result)
        }
    }

}

sealed class LoginStates {

    data class LoginResponses(val responses: LoginResponse?) : LoginStates()

    class LoadingStatus(val isLoading: Boolean) : LoginStates()

    class ErrorMessage(val message: String) : LoginStates()

}