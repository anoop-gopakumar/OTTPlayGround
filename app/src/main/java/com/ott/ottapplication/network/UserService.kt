package com.ott.ottapplication.network

import com.ott.ottapplication.network.request.Login
import com.ott.ottapplication.network.response.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface UserService {

    @GET("/users")
    suspend fun getUsers(
        @Query("per_page") per_page: Int,
        @Query("page") page: Int
    ): retrofit2.Response<List<User>>

    @Headers("x-api-key: reqres-free-v1")
    @POST("/api/login")
    suspend fun login(@Body login: Login): Response<LoginResponse>

}