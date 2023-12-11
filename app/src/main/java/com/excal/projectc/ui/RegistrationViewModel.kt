package com.excal.projectc.ui
import android.app.Application
import com.excal.projectc.data.roomdatabase.UserEntity
import com.excal.projectc.data.roomdatabase.UserRepository
import com.excal.projectc.databinding.ActivityRegistrationBinding

class RegistrationViewModel(private val repository: UserRepository,application: Application) {
    private lateinit var binding : ActivityRegistrationBinding

     fun insertUser(user:UserEntity){

     }


}