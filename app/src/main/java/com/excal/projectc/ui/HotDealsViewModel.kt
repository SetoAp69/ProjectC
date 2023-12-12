package com.excal.projectc.ui
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.excal.projectc.Repository
import com.excal.projectc.data.TopTenPhoneDailyItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
class HotDealsViewModel(private val repository: Repository): ViewModel() {
    private val _hotDealsData = MutableLiveData<List<TopTenPhoneDailyItem>>()
    val hotDealsData: LiveData<List<TopTenPhoneDailyItem>> get() = _hotDealsData

    fun fetchHotDeals() {

        repository.getHotDeals().enqueue(object : Callback<List<TopTenPhoneDailyItem>> {
            override fun onResponse(
                call: Call<List<TopTenPhoneDailyItem>>,
                response: Response<List<TopTenPhoneDailyItem>>
            ) {
                if (response.isSuccessful) {
                    _hotDealsData.value = response.body()
                }
            }

            override fun onFailure(call: Call<List<TopTenPhoneDailyItem>>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

}