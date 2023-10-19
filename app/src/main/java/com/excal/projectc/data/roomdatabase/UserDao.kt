package com.excal.projectc.data.roomdatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

    @Insert
     fun insert(register:UserEntity)

    @Insert  fun registerUser( users: UserEntity)

    @Query("SELECT * FROM user_table ORDER BY uid DESC")
    fun getAllUsers(): LiveData<List<UserEntity>>

    @Query("DELETE FROM user_table")
     fun deleteAll(): Int

    @Query("SELECT * FROM user_table WHERE email = :email")
     fun getEmail(email: String):UserEntity?
}