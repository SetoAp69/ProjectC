package com.excal.projectc.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL
import androidx.recyclerview.widget.RecyclerView
import com.excal.projectc.Search
import com.excal.projectc.data.PhoneInStoreAdapter
import com.excal.projectc.data.TopTenDailyAdapter
import com.excal.projectc.data.TopTenPhoneByUserAdapter
import com.excal.projectc.data.TopTenPhoneDailyItem
import com.excal.projectc.data.remote.ApiService
import com.excal.projectc.databinding.ActivityMenuBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.KoinComponent


class MenuActivity : AppCompatActivity() , PhoneInStoreAdapter.onItemClick, TopTenDailyAdapter.onItemCLick, TopTenPhoneByUserAdapter.onItemClick,
    KoinComponent {
    private lateinit var binding : ActivityMenuBinding
    private lateinit var viewManager:RecyclerView.LayoutManager
    private lateinit var viewManager2:RecyclerView.LayoutManager
    private lateinit var viewManager3:RecyclerView.LayoutManager
   private val hotDealsViewModel: HotDealsViewModel by viewModel()
   private val topTenDailyViewModel:TopTenDailyViewModel by viewModel()
    private val topTenByUserViewModel : TopTenByUserViewModel by viewModel()



    private val apiService: ApiService by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val editTextSearch =binding.editTextSearch
        editTextSearch.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                val searchKey = binding.editTextSearch.text.toString()
                var intent: Intent=Intent(this@MenuActivity,Search::class.java)
                intent.putExtra("key",searchKey)
                startActivity(intent)

            }
            false
        }


        viewManager = LinearLayoutManager(this,HORIZONTAL,false)
        viewManager2 = LinearLayoutManager(this,HORIZONTAL,false)
        viewManager3= LinearLayoutManager(this, HORIZONTAL,false)

        hotDealsViewModel.fetchHotDeals()
        topTenByUserViewModel.fetchTopTenByUser()
        topTenDailyViewModel.fetchTopTenDaily()
        observeHotDeals()
        observeTopTenDaily()
        observeTopTenByUser()


    }
    private fun search(){
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

    }
    private fun clickListener(){

    }
    private  fun updateTopTenDaily(topTenDaily:List<TopTenPhoneDailyItem>?){
        binding.rvTopTen.apply{
            layoutManager=LinearLayoutManager(this@MenuActivity, HORIZONTAL,false)
            adapter= TopTenDailyAdapter(this@MenuActivity,topTenDaily?: emptyList())
            adapter?.let{
                adapter->
                if(adapter is TopTenDailyAdapter){
                    adapter.listener = this@MenuActivity
                }
            }
        }
    }
    private fun observeTopTenDaily(){
        topTenDailyViewModel.topTenDailyData.observe(this,Observer{ topTenDaily ->
            updateTopTenDaily(topTenDaily)
        })
    }


    private fun updateHotDeals(hotDeals: List<TopTenPhoneDailyItem>?) {
        // Update your UI components with hotDeals data
        binding.rvHotDeals.apply {
            layoutManager = LinearLayoutManager(this@MenuActivity, HORIZONTAL, false)
            adapter = PhoneInStoreAdapter(
                baseContext,
                hotDeals ?: emptyList()
            )
            adapter?.let { adapter ->
                if (adapter is PhoneInStoreAdapter) {
                    adapter.listener = this@MenuActivity
                }
            }
        }


    }
    private fun observeHotDeals(){
        hotDealsViewModel.hotDealsData.observe(this, Observer { hotDeals ->
            // Update UI with hotDeals data
            updateHotDeals(hotDeals)

        })
    }
    private fun updateTopTenByUser(topTenByUser: List<TopTenPhoneDailyItem>){
        binding.rvTopByUser.apply {
            layoutManager = LinearLayoutManager(this@MenuActivity, HORIZONTAL,false)
            adapter= TopTenPhoneByUserAdapter(baseContext,topTenByUser)
            adapter?.let{adapter->
                if(adapter is TopTenPhoneByUserAdapter){
                    adapter.listener=this@MenuActivity
                }
            }
        }
    }
    private fun observeTopTenByUser(){
        topTenByUserViewModel.topTenByUserData.observe(this,Observer{
            topTenByUser ->
            updateTopTenByUser(topTenByUser)
        })
    }





    override fun setOnItemClick(view: View, phone: TopTenPhoneDailyItem) {
        val bundle = Bundle()
        val data=phone

        var intent: Intent=Intent(this@MenuActivity,PhoneDetailActivity::class.java)
        intent.putExtra("id",data.id)
        intent.putExtra("url",data.url)
        startActivity(intent)
    }


}