package com.example.myapplication.ui.dashboard.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.ui.dashboard.LoginState
import com.example.myapplication.ui.dashboard.intent.LoginIntent
import com.example.myapplication.ui.dashboard.model.LoginModel

class LoginViewModel() : ViewModel() {

     private val _state = MutableLiveData<LoginState>()

     val state  : LiveData<LoginState> = _state;

     fun processIntent(intent : LoginIntent){

//          val loginModel: LoginModel
//          val newState = loginModel.processIntent(intent ,_state.value)
//          _state.postValue(newState);
     }


}