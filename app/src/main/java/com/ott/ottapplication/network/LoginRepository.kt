package com.ott.ottapplication.network

import com.ott.ottapplication.network.request.Login
import com.ott.ottapplication.ui.dashboard.viewmodel.LoginStates
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class LoginRepository {

    private val scope = CoroutineScope(SupervisorJob() + CoroutineName("Login"))

    /*    fun getListOfUsers(callBack: (List<User>?) -> Unit) {
            scope.launch {
                withContext(Dispatchers.IO) {
                    val list = fetchUserList()
                    // TODO why this callback needed...
                    callBack(list)
                }
            }
        }

        suspend fun fetchUserList(): List<User>? {
            val response = ApiInstance().userService.getUsers(1, 1)
            return if (response.isSuccessful) {
                response.body()
            } else {
                null
            }
        }*/

    suspend fun login(email: String, password: String): LoginStates {
        val response = ApiInstance().userService.login(Login(email, password))
        return if (response.isSuccessful) {
            LoginStates.LoginResponses(response.body())
        } else {
            LoginStates.ErrorMessage(response.message())
        }
    }

}