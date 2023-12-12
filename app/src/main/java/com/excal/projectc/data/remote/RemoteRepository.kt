package com.excal.projectc.data.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.excal.projectc.data.TopTenPhoneDailyItem

class RemoteRepository(private val apiService: ApiService) {
    private val _topTenByUser = MutableLiveData<List<TopTenPhoneDailyItem>>()
    val topTenByUser: LiveData<List<TopTenPhoneDailyItem>> get() = _topTenByUser

    fun getTopTenByUser() = apiService.getTopTenByUser()
    fun getHotDeals()=apiService.getHotDeals()
    fun getTopTenDaily() = apiService.getTopDaily()
    fun getPhoneData( id:String)=apiService.getPhoneData(id)

    fun getSearchData(key:String)=apiService.getSearchData(key)
}