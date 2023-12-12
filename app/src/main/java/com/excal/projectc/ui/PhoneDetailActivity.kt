package com.excal.projectc.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.excal.projectc.data.PhoneSpec
import com.excal.projectc.data.PhoneSpecAdapter
import com.excal.projectc.databinding.ActivityPhoneDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class PhoneDetailActivity : AppCompatActivity() {
    private lateinit var binding:ActivityPhoneDetailBinding
    private lateinit var viewAdapter: PhoneSpecAdapter
    private val phoneDetailViewModel:PhoneDetailViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        val phoneId:String=intent.getStringExtra("id").toString()
        binding=ActivityPhoneDetailBinding.inflate(layoutInflater)
        phoneDetailViewModel.fetchSpekData(phoneId)
        observePhoneDetail()

        val imgUrl:String=intent.getStringExtra("url").toString()
        binding.dataNetwork1.text=phoneId
        Glide.with(baseContext)
            .load(imgUrl)
            .into(binding.phoneImg)

        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_phone_detail)

        setContentView(binding.root)
//        getPhoneData(ss)
    }
    private fun observePhoneDetail(){
        phoneDetailViewModel.phoneDetailData.observe(this, Observer{
            phoneData -> updatePhoneDetail(phoneData)
        })
    }
    private fun updatePhoneDetail(phoneSpek:List<PhoneSpec>?){
        binding.phoneTitle.text=phoneSpek?.get(0)!!.name
        binding.qsSoc.text=phoneSpek?.get(0)?.quickSpec?.get(0)!!.value
        binding.qsMemory.text=phoneSpek?.get(0)?.quickSpec?.get(1)!!.value
        binding.qsDisplay.text=phoneSpek?.get(0)?.quickSpec?.get(2)!!.value
        binding.qsCamera.text=phoneSpek?.get(0)?.quickSpec?.get(3)!!.value
        binding.dataNetwork1.text= phoneSpek?.get(0)?.detailSpec?.get(0)?.specifications?.get(0)!!.value
        binding.dataLaunch2.text= phoneSpek?.get(0)?.detailSpec?.get(1)?.specifications?.get(0)!!.value
        binding.dataLaunch1.text= phoneSpek?.get(0)?.detailSpec?.get(1)?.specifications?.get(1)!!.value
        binding.dataBody1.text= phoneSpek?.get(0)?.detailSpec?.get(2)?.specifications?.get(0)!!.value
        binding.dataBody3.text= phoneSpek?.get(0)?.detailSpec?.get(2)?.specifications?.get(2)!!.value
        binding.dataBody2.text= phoneSpek?.get(0)?.detailSpec?.get(2)?.specifications?.get(1)!!.value
        binding.dataDisplay1.text= phoneSpek?.get(0)?.detailSpec?.get(3)?.specifications?.get(0)!!.value
        binding.dataDisplay2.text= phoneSpek?.get(0)?.detailSpec?.get(3)?.specifications?.get(1)!!.value
        binding.dataDisplay3.text= phoneSpek?.get(0)?.detailSpec?.get(3)?.specifications?.get(2)!!.value
        binding.dataDisplay4.text= phoneSpek?.get(0)?.detailSpec?.get(3)?.specifications?.get(3)!!.value
        binding.dataPlatform1.text= phoneSpek?.get(0)?.detailSpec?.get(4)?.specifications?.get(0)!!.value
        binding.dataPlatform2.text= phoneSpek?.get(0)?.detailSpec?.get(4)?.specifications?.get(1)!!.value
        binding.dataPlatform3.text= phoneSpek?.get(0)?.detailSpec?.get(4)?.specifications?.get(2)!!.value
        binding.dataPlatform4.text= phoneSpek?.get(0)?.detailSpec?.get(4)?.specifications?.get(3)!!.value
        binding.dataMemory1.text= phoneSpek?.get(0)?.detailSpec?.get(5)?.specifications?.get(0)!!.value
        binding.dataMemory2.text= phoneSpek?.get(0)?.detailSpec?.get(5)?.specifications?.get(1)!!.value
        binding.dataRearCamera1.text= phoneSpek?.get(0)?.detailSpec?.get(6)?.specifications?.get(0)!!.value
        binding.dataRearCamera2.text= phoneSpek?.get(0)?.detailSpec?.get(6)?.specifications?.get(1)!!.value
        binding.dataRearCamera3.text= phoneSpek?.get(0)?.detailSpec?.get(6)?.specifications?.get(2)!!.value
        binding.dataSelfieCamera1.text= phoneSpek?.get(0)?.detailSpec?.get(7)?.specifications?.get(0)!!.value
        binding.dataSelfieCamera2.text= phoneSpek?.get(0)?.detailSpec?.get(7)?.specifications?.get(1)!!.value
        binding.dataSelfieCamera3.text= phoneSpek?.get(0)?.detailSpec?.get(7)?.specifications?.get(1)!!.value
        binding.dataSound1.text= phoneSpek?.get(0)?.detailSpec?.get(8)?.specifications?.get(0)!!.value
        binding.dataSound2.text= phoneSpek?.get(0)?.detailSpec?.get(8)?.specifications?.get(1)!!.value
        binding.dataComms1.text= phoneSpek?.get(0)?.detailSpec?.get(9)?.specifications?.get(0)!!.value
        binding.dataComms2.text= phoneSpek?.get(0)?.detailSpec?.get(9)?.specifications?.get(1)!!.value
        binding.dataComms3.text= phoneSpek?.get(0)?.detailSpec?.get(9)?.specifications?.get(2)!!.value
        binding.dataComms4.text= phoneSpek?.get(0)?.detailSpec?.get(9)?.specifications?.get(3)!!.value
        binding.dataComms5.text= phoneSpek?.get(0)?.detailSpec?.get(9)?.specifications?.get(4)!!.value
        binding.dataComms6.text= phoneSpek?.get(0)?.detailSpec?.get(9)?.specifications?.get(5)!!.value
        //binding.dataComms7.text= phoneSpek?.get(0)?.detailSpec?.get(9)?.specifications?.get(6)!!.value
        binding.dataBattery1.text = phoneSpek?.get(0)?.detailSpec?.get(11)?.specifications?.get(0)!!.value
        binding.dataBattery2.text = phoneSpek?.get(0)?.detailSpec?.get(11)?.specifications?.get(1)!!.value
        binding.dataMisc1.text = phoneSpek?.get(0)?.detailSpec?.get(12)?.specifications?.get(0)!!.value
        binding.dataMisc2.text = phoneSpek?.get(0)?.detailSpec?.get(12)?.specifications?.get(1)!!.value














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
//    private fun getPhoneData(id:String) {
//        var httpClient: OkHttpClient.Builder = OkHttpClient.Builder()
//            .callTimeout(2, TimeUnit.MINUTES)
//            .connectTimeout(2, TimeUnit.MINUTES)
//            .readTimeout(2, TimeUnit.MINUTES)
//            .writeTimeout(2, TimeUnit.MINUTES)
//
//
//        val retrofit = Retrofit.Builder()
//            .baseUrl("http://192.168.1.3:3001/PhoneData/")
//            .addConverterFactory(GsonConverterFactory.create())
//
//            .client(httpClient.build())
//            .build()
//            .create(ApiService::class.java)
//
////        retrofit.getPhoneData(id).enqueue(object:retrofit2.Callback<Response<PhoneSpec>>{
////            override fun onResponse(
////                call: Call<Response<PhoneSpec>>,
////                response: Response<Response<PhoneSpec>>
////            ) {
////                if(response.isSuccessful){
////                    response.body()?.let{
////                        val detailSpec = it.body()?.detailSpec
////                        binding.dataNetwork1.text= detailSpec?.get(1)?.specifications?.get(1)?.value
////                    }
////
//////                    if(data!=null){
//////                        binding.dataNetwork1.text=
//////                    }
////                }
////
////
////            }
////            override fun onFailure(call: Call<Response<PhoneSpec>>, t: Throwable) {
////                t.printStackTrace()
////            }
////
////        })
//
////        CoroutineScope(Dispatchers.IO).launch {
////            val response = retrofit.getPhoneData(id)
////            if(response.isSuccessful){
////                response.body()?.let{
////                    val detailSpec  =  it.detailSpec
////                    val quickSpec = it.quickSpec
////                    binding.dataNetwork1.text=detailSpec[0].specifications[0].value
////                }
////            }
////
////        }
//
//
//
//    }
}