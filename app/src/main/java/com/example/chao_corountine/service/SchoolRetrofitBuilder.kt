package com.example.chao_corountine.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object SchoolRetrofitBuilder  {
    private const val  BASE_URL = "http://..."

    val retrofitBuilder: Retrofit.Builder by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
    }

    val apiService: SchoolApiService by lazy {
        retrofitBuilder
            .build()
            .create(SchoolApiService::class.java)
    }


}