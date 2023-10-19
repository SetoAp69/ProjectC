package com.excal.projectc.ui
import android.app.Application
import android.content.Intent
import androidx.lifecycle.ViewModel
import android.view.View
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.excal.projectc.data.roomdatabase.UserEntity
import com.excal.projectc.data.roomdatabase.UserRepository
import com.excal.projectc.databinding.ActivityRegistrationBinding

class RegistrationViewModel(private val repository: UserRepository,application: Application) {
    private lateinit var binding : ActivityRegistrationBinding

}