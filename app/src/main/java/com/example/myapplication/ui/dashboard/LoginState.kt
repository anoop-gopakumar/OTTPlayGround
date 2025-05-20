package com.example.myapplication.ui.dashboard

import com.example.myapplication.network.User
import com.example.myapplication.ui.dashboard.model.LoginModel

data class LoginState(val error : Exception?, val data : List<User>?, val isLoading:Boolean) {



}