package com.excal.projectc.data.roomdatabase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
      fun insert(register:UserEntity)





    @Query("SELECT * FROM user_table WHERE email = :email AND password = :password")
     fun getUser(email: String, password: String):UserEntity
}