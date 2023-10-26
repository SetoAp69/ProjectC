package com.excal.projectc.ui
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import com.excal.projectc.apidata.Phone

class PhoneInStoreViewModel :ViewModel(){
    private val _phoneList = MutableLiveData<ArrayList<Phone>>()
    val phoneList : MutableLiveData<ArrayList<Phone>> = _phoneList

}