package com.ott.ottapplication.usecase

import com.ott.ottapplication.network.LoginRepository
import com.ott.ottapplication.ui.dashboard.viewmodel.LoginStates

class LoginUseCaseImpl(private val loginRepository: LoginRepository) : LoginUseCase {

    override suspend fun login(userName: String, password: String) : LoginStates {
        return loginRepository.login(userName, password)
    }
}