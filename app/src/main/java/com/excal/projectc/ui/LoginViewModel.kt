package com.excal.projectc.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.excal.projectc.Repository
import com.excal.projectc.data.roomdatabase.UserEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: Repository) : ViewModel() {

    private val isLogin = MutableLiveData<UserEntity>()
    fun observeIsLogin(): LiveData<UserEntity> = isLogin
    fun getDataLogin(email:String, password: String){
        viewModelScope.launch(Dispatchers.IO) {
            when(val result =repository.getUser(email,password)){
                is UserEntity -> {
                    isLogin.postValue(result!!)
                }


            }
        }
    }

}

