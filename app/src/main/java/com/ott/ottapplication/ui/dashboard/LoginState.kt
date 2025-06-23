package com.ott.ottapplication.ui.dashboard

import com.ott.ottapplication.network.User

data class LoginState(val error : Exception?, val data : List<User>?, val isLoading:Boolean) {



}