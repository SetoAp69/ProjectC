package com.excal.projectc

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL
import com.excal.projectc.data.TopTenPhoneDailyItem
import com.excal.projectc.databinding.ActivitySearchBinding
import com.excal.projectc.ui.PhoneDetailActivity
import com.excal.projectc.ui.SearchAdapter
import com.excal.projectc.ui.SearchViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.KoinComponent

class Search : AppCompatActivity() ,SearchAdapter.onItemClick,KoinComponent{
    private lateinit var binding: ActivitySearchBinding
    private val searchViewModel:SearchViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val searchKey:String = intent.getStringExtra("key").toString()

        searchViewModel.fetchSearchData(searchKey)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val editTextSearch =binding.editTextSearch
        editTextSearch.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                val searchKey = binding.editTextSearch.text.toString()
                var intent: Intent=Intent(this@Search,Search::class.java)
                intent.putExtra("key",searchKey)
                startActivity(intent)

            }
            false
        }
        binding.title.text="Search Result"
        observeSearchDetail()
    }
    private fun observeSearchDetail(){
        searchViewModel.searchData.observe(this, Observer{
            data-> updateSearchData(data)
        })
    }
    private fun updateSearchData(topTenPhoneDailyItem: List<TopTenPhoneDailyItem>?){
        binding.rvTopByUser.apply{
            layoutManager=GridLayoutManager(this@Search,2,HORIZONTAL,false)
            adapter = SearchAdapter(this@Search,topTenPhoneDailyItem?: emptyList())
            adapter?.let{
                adapter->
                if(adapter is SearchAdapter){
                    adapter.listener= this@Search
                }
            }
        }
    }
    override fun setOnItemClick(view: View, phone: TopTenPhoneDailyItem) {
        val bundle = Bundle()
        val data=phone

        var intent: Intent = Intent(this@Search, PhoneDetailActivity::class.java)
        intent.putExtra("id",data.id)
        intent.putExtra("url",data.url)
        startActivity(intent)
    }
}