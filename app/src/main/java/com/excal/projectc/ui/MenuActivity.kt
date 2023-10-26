package com.excal.projectc.ui

import ApiService
import TopTenPhoneViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL
import androidx.recyclerview.widget.RecyclerView
import com.excal.projectc.databinding.ActivityMenuBinding

import android.webkit.WebView
import android.webkit.WebViewClient
import okhttp3.OkHttpClient
import okhttp3.Request


class MenuActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMenuBinding
    private lateinit var viewAdapter : PhoneAdapter
    private lateinit var viewManager:RecyclerView.LayoutManager
    private lateinit var viewManager2:RecyclerView.LayoutManager
    private lateinit var viewManager3:RecyclerView.LayoutManager

    private lateinit var viewModel: PhoneViewModel
    private lateinit var viewModel2:PhoneInStoreViewModel
    private lateinit var viewModel3:TopTenPhoneViewModel
    private lateinit var viewAdapter2:PhoneInStoreAdapter
    private lateinit var viewAdapter3:TopTenPhoneAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_menu)
        binding= ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel= ViewModelProvider(this)[PhoneViewModel::class.java]

        viewManager = LinearLayoutManager(this,HORIZONTAL,false)
        viewManager2 = LinearLayoutManager(this,HORIZONTAL,false)
        viewManager3= LinearLayoutManager(this, HORIZONTAL,false)
        viewAdapter= PhoneAdapter(viewModel)

        viewModel2=ViewModelProvider(this)[PhoneInStoreViewModel::class.java]
        viewAdapter2=PhoneInStoreAdapter(viewModel2)

        viewModel3=ViewModelProvider(this)[TopTenPhoneViewModel::class.java]
        viewAdapter3=TopTenPhoneAdapter(viewModel3)

        binding.latestDevice.apply{
            layoutManager=viewManager
            adapter = viewAdapter
        }
//
        binding.inStore.apply{
            layoutManager=viewManager2
            adapter=viewAdapter2
        }

        binding.topTen.apply{
            layoutManager=viewManager3
            adapter=viewAdapter3
        }




//        val webView = findViewById<WebView>(this)
//        webView.settings.javaScriptEnabled = true
//
//        // Set a WebViewClient to handle navigation within the WebView
//        webView.webViewClient = WebViewClient()
//
//        // Load the HTML file from the assets folder
//        webView.loadUrl("data.html")


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

}