package com.excal.projectc.data.di

import com.excal.projectc.data.remote.ApiService
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
val networkModule = module {
    single<OkHttpClient> {
        OkHttpClient.Builder()
            .callTimeout(20, TimeUnit.MINUTES)
            .connectTimeout(20, TimeUnit.MINUTES)
            .readTimeout(20, TimeUnit.MINUTES)
            .writeTimeout(20, TimeUnit.MINUTES)
            .build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl("http://192.168.25.35:3001/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
    }

    single<ApiService> {
        get<Retrofit>().create(ApiService::class.java)
    }
}
