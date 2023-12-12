package com.excal.projectc.data.remote
import com.excal.projectc.data.PhoneSpec
import com.excal.projectc.data.TopTenPhoneDailyItem
import com.excal.projectc.ui.PhoneImage
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("/TopTenDaily")
    fun getTopDaily(): Call<List<TopTenPhoneDailyItem>>

    @GET("/TopTenByUser")
    fun getTopTenByUser(): Call<List<TopTenPhoneDailyItem>>

    @GET("/HotDeals")
    fun getHotDeals(): Call<List<TopTenPhoneDailyItem>>

    @GET("/Image/{id}")
    fun getImageById(@Path("id") phoneId: Int): Call<List<PhoneImage>>

    @GET("/PhoneData")
    fun getPhoneData(@Query("id") id: String): Call<List<PhoneSpec>>

    @GET("/Search")
    fun getSearchData(@Query("key") id: String): Call<List<TopTenPhoneDailyItem>>
}

