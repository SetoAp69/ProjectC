package com.excal.projectc.data.roomdatabase
import android.util.Log
import androidx.lifecycle.LiveData
class UserRepository (private val dao:UserDao){
    val users = dao.getAllUsers()
    suspend fun insert(user:UserEntity){
        return dao.insert(user)
    }
    suspend fun getUserName(email:String):UserEntity?{
        Log.i("USERREPOTAG","inside Repository Getusers fun")
        return dao.getEmail(email)
    }
}