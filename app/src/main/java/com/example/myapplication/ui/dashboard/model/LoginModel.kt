package com.example.myapplication.ui.dashboard.model

import com.example.myapplication.ui.dashboard.LoginRepository
import com.example.myapplication.ui.dashboard.LoginState
import com.example.myapplication.ui.dashboard.intent.LoginIntent

class  LoginModel(val repository : LoginRepository) {

   fun processIntent(intent : LoginIntent , currentState: LoginState?) :LoginState {
       return  when  (intent){
           is LoginIntent.LoadData -> {
               repository.getListOfUsers { users ->
                   LoginState(null, users,false );
                   currentState?.copy(data = users)?: LoginState( error = null, data = users, isLoading = false);
               }
               currentState?.copy(data = null)
               LoginState(null, null,true );
           }
           is LoginIntent.UpdateData -> {
               //repository.
               intent.newData
               LoginState(null, null,false );
           }
           is LoginIntent.deleteData -> {
               LoginState(null, null,false );
           }

       }
   }
}