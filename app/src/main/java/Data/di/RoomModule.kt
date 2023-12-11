package com.excal.projectc.Module

import androidx.room.Room
import com.excal.projectc.data.roomdatabase.UserDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val roomModule = module{
    single{
        Room.databaseBuilder(androidContext(), UserDatabase::class.java, "app-database")
            .build()

    }

}