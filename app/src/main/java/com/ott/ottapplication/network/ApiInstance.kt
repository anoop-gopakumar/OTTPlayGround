package com.ott.ottapplication.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiInstance {

    companion object {
        private val retrofitBuilder: Retrofit.Builder =
            Retrofit.Builder()
                .baseUrl("https://reqres.in/api/")
                .addConverterFactory(GsonConverterFactory.create())
    }

    private val retrofit:Retrofit = retrofitBuilder.build()

    private val httpClient: OkHttpClient.Builder
            = OkHttpClient.Builder()

    var retrofitAPI: UserService = retrofit.create(UserService::class.java)

}

private val logging:HttpLoggingInterceptor
        = HttpLoggingInterceptor()
    .setLevel(HttpLoggingInterceptor.Level.BASIC)


