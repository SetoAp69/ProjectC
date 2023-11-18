package com.excal.projectc.data.roomdatabase
import androidx.room.Entity
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

@Entity(tableName="user_table")
data class UserEntity (
    @PrimaryKey(autoGenerate = true) val uid:Int =0,


    @ColumnInfo(name ="userName") val userName:String?,

    @ColumnInfo(name ="email") val email:String?,

    @ColumnInfo(name="password") val password:String?










    )