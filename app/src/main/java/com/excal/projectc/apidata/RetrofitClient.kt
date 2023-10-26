package com.excal.projectc.apidata

import ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient{
    const val BASE_URL = "https://mobile-phone-specs-database.p.rapidapi.com/gsm/get-models-by-brandname/Samsung"
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: ApiService = retrofit.create(ApiService::class.java)

}