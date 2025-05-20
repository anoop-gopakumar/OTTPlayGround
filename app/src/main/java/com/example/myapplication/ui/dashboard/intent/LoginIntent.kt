package com.example.myapplication.ui.dashboard.intent

import com.example.myapplication.ui.dashboard.model.LoginModel

sealed class LoginIntent {

        object LoadData : LoginIntent()

        data class UpdateData(val newData : LoginModel) : LoginIntent()

        object deleteData : LoginIntent();


}