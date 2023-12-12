package com.excal.projectc.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.excal.projectc.Repository
import com.excal.projectc.data.PhoneSpec
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PhoneDetailViewModel(private val repository: Repository): ViewModel() {
    private val _phoneDetailData = MutableLiveData<List<PhoneSpec>>()
    val phoneDetailData: LiveData<List<PhoneSpec>> get()=_phoneDetailData

    fun fetchSpekData(id:String){
        repository.getPhoneData(id).enqueue(object : Callback<List<PhoneSpec>>{
            override fun onResponse(
                call: Call<List<PhoneSpec>>,
                response: Response<List<PhoneSpec>>
            ) {
                if(response.isSuccessful){
                    _phoneDetailData.value=response.body()
                }
            }

            override fun onFailure(call: Call<List<PhoneSpec>>, t: Throwable) {

                t.printStackTrace()
            }
        })
    }
}