package com.excal.projectc.ui
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.excal.projectc.Repository
import com.excal.projectc.data.TopTenPhoneDailyItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
class TopTenDailyViewModel(private val repository: Repository): ViewModel() {
    private val _topTenDailyData = MutableLiveData<List<TopTenPhoneDailyItem>>()
    val topTenDailyData: LiveData<List<TopTenPhoneDailyItem>> get() = _topTenDailyData

    fun fetchTopTenDaily() {

        repository.getTopDaily().enqueue(object : Callback<List<TopTenPhoneDailyItem>> {
            override fun onResponse(
                call: Call<List<TopTenPhoneDailyItem>>,
                response: Response<List<TopTenPhoneDailyItem>>
            ) {
                if (response.isSuccessful) {
                    _topTenDailyData.value = response.body()
                }
            }

            override fun onFailure(call: Call<List<TopTenPhoneDailyItem>>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

}