package com.excal.projectc.data.roomdatabase

import androidx.room.Database
import androidx.room.Entity
import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities =[UserEntity::class] , version = 1)
abstract class  UserDatabase :RoomDatabase() {

//    abstract val userDao:UserDao
//
//    companion object{
//        @Volatile
//        private var INSTANCE: UserDatabase? = null
//
//        fun getInstance(context:Context):UserDatabase {
//            synchronized(this){
//                var instance = INSTANCE
//                if(instance == null){
//                    instance == Room.databaseBuilder(
//                        context.applicationContext,
//                        UserDatabase::class.java,
//                        "user_database"
//                    )
//                        .fallbackToDestructiveMigration()
//                        .build()
//                    INSTANCE = instance
//                }
//                return instance!!
//            }
//        }
//    }

    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: UserDatabase? = null

        fun getInstance(context: Context): UserDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "app-database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}

//package com.excal.projectc.data;
//import android.content.Context
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//import com.excal.projectc.data.roomdatabase.UserEntity
//import com.excal.projectc.data.roomdatabase.UserDao
//
//@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
//abstract class UserDatabase : RoomDatabase() {
//    abstract fun userDao(): UserDao
//
//    companion object {
//        @Volatile
//        private var INSTANCE: UserDatabase? = null
//
//        fun getDatabase(context: Context): UserDatabase {
//            val tempInstance = INSTANCE
//            if (tempInstance != null) {
//                return tempInstance
//            }
//            synchronized(this) {
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    UserDatabase::class.java,
//                    "user_database"
//                ).build()
//                INSTANCE = instance
//                return instance
//            }
//        }
//    }
//}