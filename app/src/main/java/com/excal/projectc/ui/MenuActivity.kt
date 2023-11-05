package com.excal.projectc.ui

import Data.PhoneInStoreAdapter
import Data.TopTenPhoneAdapter
import Data.TopTenPhoneByUserAdapter
import Data.TopTenPhoneDailyItem
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL
import androidx.recyclerview.widget.RecyclerView
import com.excal.projectc.ApiService
import com.excal.projectc.databinding.ActivityMenuBinding
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MenuActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMenuBinding
    private lateinit var viewAdapter : TopTenPhoneByUserAdapter
    private lateinit var viewManager:RecyclerView.LayoutManager
    private lateinit var viewManager2:RecyclerView.LayoutManager
    private lateinit var viewManager3:RecyclerView.LayoutManager

    private lateinit var viewModel: PhoneViewModel
    private lateinit var viewModel2:PhoneInStoreViewModel
    private lateinit var viewModel3:TopTenPhoneViewModel
    private lateinit var viewAdapter2: PhoneInStoreAdapter
    private lateinit var viewAdapter3: TopTenPhoneAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_menu)
        binding= ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
  //      viewModel= ViewModelProvider(this)[PhoneViewModel::class.java]

        viewManager = LinearLayoutManager(this,HORIZONTAL,false)
        viewManager2 = LinearLayoutManager(this,HORIZONTAL,false)
        viewManager3= LinearLayoutManager(this, HORIZONTAL,false)
      //  viewAdapter= PhoneAdapter(viewModel)

//        viewModel2=ViewModelProvider(this)[PhoneInStoreViewModel::class.java]
//        viewAdapter2= PhoneInStoreAdapter(viewModel2)

//        viewModel3=ViewModelProvider(this)[TopTenPhoneViewModel::class.java]
//        viewAdapter3=TopTenPhoneAdapter(viewModel3)
//
//        binding.latestDevice.apply{
//            layoutManager=viewManager
//            adapter = viewAdapter
//        }
//
//        binding.inStore.apply{
//            layoutManager=viewManager2
//            adapter=viewAdapter2
//        }
        getTopDaily()
        getHotDeals()
        getTopByUser()



//        val mFragManager = supportFragmentManager
//        val fragment=PhoneList()
//        val frag = mFragManager.findFragmentByTag(PhoneList::class.java.simpleName)
//        if(frag !is PhoneList ){
//            mFragManager
//                .beginTransaction()
//                .add(R.id.fragment_container, fragment,PhoneList::class.java.simpleName)
//                .commit()
//        }


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

    private fun getHotDeals(){
        var retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.1.3:3001/TopTenDaily/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

        retrofit.getUsers().enqueue(object:retrofit2.Callback<List<TopTenPhoneDailyItem>>{
            override fun onResponse(
                call: retrofit2.Call<List<TopTenPhoneDailyItem>>,
                response: retrofit2.Response<List<TopTenPhoneDailyItem>>
            ){
                if(response.isSuccessful){
                    val data=response.body()!!
                    viewAdapter2 = PhoneInStoreAdapter(baseContext, data)
                    binding.rvHotDeals.apply {
                        layoutManager = viewManager2
                        adapter = viewAdapter2
                    }


                }
            }
            override fun onFailure(call: retrofit2.Call<List<TopTenPhoneDailyItem>>, t: Throwable) {
                t.printStackTrace()
            }


        })
    }
    private fun getTopDaily(){
        var retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.1.3:3001/TopTenDaily/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

        retrofit.getUsers().enqueue(object:retrofit2.Callback<List<TopTenPhoneDailyItem>>{
            override fun onResponse(
                call: retrofit2.Call<List<TopTenPhoneDailyItem>>,
                response: retrofit2.Response<List<TopTenPhoneDailyItem>>
            ){
                if(response.isSuccessful){
                    val data=response.body()!!
                    viewAdapter3 = TopTenPhoneAdapter(baseContext, data)
                    binding.rvTopTen.apply {
                        layoutManager = viewManager3
                        adapter = viewAdapter3
                    }


            }
        }
            override fun onFailure(call: retrofit2.Call<List<TopTenPhoneDailyItem>>, t: Throwable) {
                t.printStackTrace()
            }


        })
    }
    private fun getTopByUser(){
        var retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.1.3:3001/TopTenByUser/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

        retrofit.getTopTenByUser().enqueue(object:retrofit2.Callback<List<TopTenPhoneDailyItem>>{
            override fun onResponse(
                call: retrofit2.Call<List<TopTenPhoneDailyItem>>,
                response: retrofit2.Response<List<TopTenPhoneDailyItem>>
            ){
                if(response.isSuccessful){
                    val data=response.body()!!
                    viewAdapter = TopTenPhoneByUserAdapter(baseContext, data)
                    binding.rvTopByUser.apply {
                        layoutManager = viewManager
                        adapter = viewAdapter
                    }


                }
            }
            override fun onFailure(call: retrofit2.Call<List<TopTenPhoneDailyItem>>, t: Throwable) {
                t.printStackTrace()
            }


        })
    }


}