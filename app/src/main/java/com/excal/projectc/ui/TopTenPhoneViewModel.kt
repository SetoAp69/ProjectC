package com.excal.projectc.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class TopTenPhoneViewModel :ViewModel(){
    private val _phoneList = MutableLiveData<ArrayList<Phone>>()
    val phoneList : MutableLiveData<ArrayList<Phone>> = _phoneList
    init {
        _phoneList.value = arrayListOf(
            Phone(
                id = 1,
                title = "Samsung Galaxy S20 FE",

                ),
            Phone(
                id = 2,
                title = "Iphone 15 Pro"
            ),
            Phone(
                id = 3,
                title = "Iphone 14 Pro"
            ),
            Phone(
                id = 4,
                title = "Xiaomi 13T"
            ),
            Phone(
                id = 5,
                title = "Samsung Galaxy 21 Ultra"
            ),
            Phone(
                id = 6,
                title = "Poco F5 Pro"
            ),
            Phone(
                id = 7,
                title = "Samsung Galaxy A54"
            ),
        )

    }
}