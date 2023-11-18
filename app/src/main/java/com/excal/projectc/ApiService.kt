package com.excal.projectc
import Data.TopTenPhoneDailyItem
import com.excal.projectc.ui.PhoneImage
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/TopTenDaily")
    fun getUsers(): Call<List<TopTenPhoneDailyItem>>

    @GET("/TopTenByUser")
    fun getTopTenByUser(): Call<List<TopTenPhoneDailyItem>>

    @GET("/HotDeals")
    fun getHotDeals(): Call<List<TopTenPhoneDailyItem>>

    @GET("/Image/{id}")
    fun getImageById(@Path("id") phoneId:Int):Call<List<PhoneImage>>
}