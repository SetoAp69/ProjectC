package com.excal.projectc.Module

import Data.TopTenPhoneDailyItem
import Data.remote.ApiService
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.excal.projectc.ui.HotDealsViewModel
import com.excal.projectc.ui.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

val ViewModelModule = module {
    viewModel { HotDealsViewModel(get()) }

}