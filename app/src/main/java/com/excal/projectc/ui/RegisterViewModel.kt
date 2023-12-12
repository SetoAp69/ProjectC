package com.excal.projectc.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.excal.projectc.Repository
import com.excal.projectc.data.roomdatabase.UserEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegisterViewModel(private val repository: Repository): ViewModel() {

    private val isRegister = MutableLiveData<Boolean>()
    fun observeIsRegister():LiveData<Boolean> = isRegister


    fun insertUser(user: UserEntity){
        viewModelScope.launch(Dispatchers.IO) {
            try{
                repository.insertUser(user)
                isRegister.postValue(true)
            }catch (e:Throwable){
                e.printStackTrace()
            }
        }
    }
}