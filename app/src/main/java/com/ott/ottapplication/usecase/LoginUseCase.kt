package com.ott.ottapplication.usecase

import com.ott.ottapplication.ui.dashboard.viewmodel.LoginStates

interface LoginUseCase {


    suspend fun login(userName: String, password: String) : LoginStates


}