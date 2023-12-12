package com.excal.projectc.data.di

import com.excal.projectc.ui.HotDealsViewModel
import com.excal.projectc.ui.LoginViewModel
import com.excal.projectc.ui.PhoneDetailViewModel
import com.excal.projectc.ui.RegisterViewModel
import com.excal.projectc.ui.SearchViewModel
import com.excal.projectc.ui.TopTenByUserViewModel
import com.excal.projectc.ui.TopTenDailyViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module(override = true) {
//    viewModel (named("Top_ten_byUser")) { TopTenByUserViewModel(get()) }
//    viewModel (named("Hot_deals")) { HotDealsViewModel(get()) }
//    viewModel (named("Top_daily")) { TopTenDailyViewModel(get()) }
    viewModel{
        TopTenDailyViewModel(get())
    }
    viewModel{
        HotDealsViewModel(get())
    }
    viewModel{
        TopTenByUserViewModel(get())
    }
    viewModel{
        PhoneDetailViewModel(get())
    }
    viewModel{
        SearchViewModel(get())
    }

    single { LoginViewModel(get()) }
    single { RegisterViewModel(get()) }

}