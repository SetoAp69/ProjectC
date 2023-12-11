package com.excal.projectc.ui

import Data.PhoneSpec
import Data.PhoneSpecAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import Data.remote.ApiService
import com.excal.projectc.databinding.ActivityPhoneDetailBinding
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class PhoneDetailActivity : AppCompatActivity() {
    private lateinit var binding:ActivityPhoneDetailBinding
    private lateinit var viewAdapter: PhoneSpecAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        val ss:String=intent.getStringExtra("id").toString()

        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_phone_detail)
        binding=ActivityPhoneDetailBinding.inflate(layoutInflater)

        setContentView(binding.root)
        getPhoneData(ss)
    }
    override fun onStart() {
        super.onStart()
    }
    override fun onPause() {
        super.onPause()

    }

    override fun onDestroy() {
        super.onDestroy()

    }

    override fun onStop() {
        super.onStop()
    }
    private fun getPhoneData(id:String) {
        var httpClient: OkHttpClient.Builder = OkHttpClient.Builder()
            .callTimeout(2, TimeUnit.MINUTES)
            .connectTimeout(2, TimeUnit.MINUTES)
            .readTimeout(2, TimeUnit.MINUTES)
            .writeTimeout(2, TimeUnit.MINUTES)


        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.1.3:3001/PhoneData/")
            .addConverterFactory(GsonConverterFactory.create())

            .client(httpClient.build())
            .build()
            .create(ApiService::class.java)

        retrofit.getPhoneData(id).enqueue(object:retrofit2.Callback<Response<PhoneSpec>>{
            override fun onResponse(
                call: Call<Response<PhoneSpec>>,
                response: Response<Response<PhoneSpec>>
            ) {
                if(response.isSuccessful){
                    response.body()?.let{
                        val detailSpec = it.body()?.detailSpec
                        binding.dataNetwork1.text= detailSpec?.get(1)?.specifications?.get(1)?.value
                    }

//                    if(data!=null){
//                        binding.dataNetwork1.text=
//                    }
                }


            }
            override fun onFailure(call: Call<Response<PhoneSpec>>, t: Throwable) {
                t.printStackTrace()
            }

        })

//        CoroutineScope(Dispatchers.IO).launch {
//            val response = retrofit.getPhoneData(id)
//            if(response.isSuccessful){
//                response.body()?.let{
//                    val detailSpec  =  it.detailSpec
//                    val quickSpec = it.quickSpec
//                    binding.dataNetwork1.text=detailSpec[0].specifications[0].value
//                }
//            }
//
//        }



    }
}