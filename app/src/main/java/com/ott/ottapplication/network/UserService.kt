package com.ott.ottapplication.network

import retrofit2.http.GET
import retrofit2.http.Query

interface UserService {


    @GET("/users")
    suspend fun getUsers(
        @Query("per_page") per_page: Int,
        @Query("page") page: Int
    ): retrofit2.Response<List<User>>



}