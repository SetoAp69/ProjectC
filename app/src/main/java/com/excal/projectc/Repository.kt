package com.excal.projectc

import com.excal.projectc.data.remote.RemoteRepository
import com.excal.projectc.data.roomdatabase.LocalRepository
import com.excal.projectc.data.roomdatabase.UserEntity

class Repository (private val localRepository: LocalRepository, private val remoteRepository: RemoteRepository){
    suspend fun insertUser(userEntity: UserEntity){
        localRepository.insertUser(userEntity)
    }
    suspend fun getUser(email:String,password:String):UserEntity?{
        return localRepository.getUser(email,password)
    }
    fun getTopTenByUser() = remoteRepository.getTopTenByUser()
    fun getTopDaily()=remoteRepository.getTopTenDaily()
    fun getHotDeals()=remoteRepository.getHotDeals()
    fun getPhoneData(id:String)=remoteRepository.getPhoneData(id)
    fun getSearchData(key:String)=remoteRepository.getSearchData(key)

}