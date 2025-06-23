package com.ott.ottapplication.ui.dashboard.intent

import com.ott.ottapplication.ui.dashboard.model.LoginModel

sealed class LoginIntent {

        object LoadData : LoginIntent()

        data class UpdateData(val newData : LoginModel) : LoginIntent()

        object deleteData : LoginIntent();


}