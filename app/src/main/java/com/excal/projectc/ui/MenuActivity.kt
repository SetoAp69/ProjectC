package com.excal.projectc.ui

import android.content.Intent
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.excal.projectc.databinding.ActivityMenuBinding
import com.excal.projectc.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView
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
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import android.view.Window
import com.excal.projectc.AboutFragment
import com.excal.projectc.HomeFragment
import com.excal.projectc.SettingsFragment
import com.excal.projectc.ShareFragment
import com.excal.projectc.R


class MenuActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

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

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        drawerLayout = binding.drawerLayout
        val toolbar: Toolbar = binding.toolbar
        setSupportActionBar(toolbar)

        val navigationView: NavigationView = binding.navView
        navigationView.setNavigationItemSelectedListener(this)

        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.open_nav,
            R.string.close_nav
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment())
                .commit()
            navigationView.setCheckedItem(R.id.nav_home)
        }

        // Call your functions here
        getTopDaily()
        getHotDeals()
        getTopByUser()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment())
                .commit()
            R.id.nav_settings -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, SettingsFragment())
                .commit()
            R.id.nav_share -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ShareFragment())
                .commit()
            R.id.nav_about -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, AboutFragment())
                .commit()
            R.id.nav_logout -> {
                Toast.makeText(this, "Logout!", Toast.LENGTH_SHORT).show()
                // Add logout logic here if needed
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
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