package com.excal.projectc.data.roomdatabase

class LocalRepository (private val appDatabase: UserDatabase){
    suspend fun insertUser(userEntity: UserEntity){
        appDatabase.userDao().insert(userEntity)
    }
    suspend fun getUser(email:String): UserEntity? {
        return appDatabase.userDao().getEmail(email)
    }
}