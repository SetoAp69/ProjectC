package com.excal.projectc

import Data.remote.RemoteRepository
import com.excal.projectc.data.roomdatabase.LocalRepository
import com.excal.projectc.data.roomdatabase.UserEntity

class Repository (private val localRepository: LocalRepository, private val remoteRepository: RemoteRepository){
    suspend fun insertUser(userEntity: UserEntity){
        localRepository.insertUser(userEntity)
    }
    suspend fun getUser(email:String):UserEntity?{
        return localRepository.getUser(email)
    }

}