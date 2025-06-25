package com.ott.ottapplication.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiInstance {

    companion object {

        private val logging: HttpLoggingInterceptor =
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        private val httpClient: OkHttpClient.Builder =
            OkHttpClient.Builder().addInterceptor(logging)

        private val retrofitBuilder: Retrofit.Builder =
            Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
    }

    private val retrofit: Retrofit = retrofitBuilder.build()
    var userService: UserService = retrofit.create(UserService::class.java)

}




