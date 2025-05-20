package com.example.myapplication.ui.dashboard

import com.example.myapplication.network.ApiInstance
import com.example.myapplication.network.User
import com.example.myapplication.network.Users
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginRepository {

    private val scope = CoroutineScope(SupervisorJob() + CoroutineName("Login"))

    fun getListOfUsers( callBack:(List<User>?) -> Unit  ) {
        scope.launch {
            withContext(Dispatchers.IO) {
                val list = fetchUserList()
                callBack(list)
            }
        }
    }

    private suspend fun fetchUserList(): List<User>? {
        val response = ApiInstance().retrofitAPI.getUsers(1, 1)
        return if (response.isSuccessful) {
            response.body()
        } else {
            null
        }
    }

}