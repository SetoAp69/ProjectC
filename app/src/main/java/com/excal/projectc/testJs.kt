package com.excal.projectc

import Data.remote.ApiService
import Data.TopTenPhoneDailyItem
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.excal.projectc.databinding.ActivityTestJsBinding
import com.excal.projectc.ui.TopTenDailyAdapter
import com.google.gson.Gson
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class testJs : AppCompatActivity() {

    private lateinit var binding: ActivityTestJsBinding
    private lateinit var viewAdapter: TopTenDailyAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager


    private fun getTopDaily(){
        var retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.1.3:3001/TopTenDaily/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

        retrofit.getUsers().enqueue(object : retrofit2.Callback<List<TopTenPhoneDailyItem>> {
            override fun onResponse(
                call: retrofit2.Call<List<TopTenPhoneDailyItem>>,
                response: retrofit2.Response<List<TopTenPhoneDailyItem>>
            ){
                if (response.isSuccessful){
                    val data = response.body()!!

                    viewAdapter = TopTenDailyAdapter(baseContext, data)
                    binding.itemRv.apply {
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val gson = Gson()
        binding = ActivityTestJsBinding.inflate(layoutInflater)
        viewManager = LinearLayoutManager(this)
        getTopDaily()

        setContentView(binding.root)

//        val v8 = V8.createV8Runtime()
//
//
//
//        val assetManager = assets
//        val inputStream: InputStream = assetManager.open("sc.js")
//        val size: Int = inputStream.available()
//        val buffer = ByteArray(size)
//        inputStream.read(buffer)
//        inputStream.close()
//
//        val jsCode = String(buffer)
//
//        val javaScript="file:///android_asset/test.js"
//        val inputStream2: InputStream = assetManager.open("my_module_loader.js")
//        val size2: Int = inputStream2.available()
//        val buffer2 = ByteArray(size2)
//        inputStream2.read(buffer2)
//        inputStream2.close()
//        val moduleLoaderScript="file:///android_asset/my_module_loader.js"
//        v8.executeVoidScript(String(buffer2))
//
//        val x = String(buffer2)
//        val result = v8.executeScript(jsCode)
//
//        val phone=v8.executeStringFunction("getPhone",null)
//


        val client = OkHttpClient()
        val request = Request.Builder()
            .url("http://192.168.1.3:3001/getPhoneSpecs")
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                // Handle request failure
                val textView = findViewById<TextView>(R.id.tv_title)


            }

            override fun onResponse(call: Call, response: Response) {
                val jsonData = response.body!!.string().trimIndent()
                // Parse and use the data from your JavaScript library
                val textView = findViewById<TextView>(R.id.tv_title)
                runOnUiThread {
                    // UI-related code here
                    val textView = findViewById<TextView>(R.id.tv_title)


                }



            }


        })




    }
}