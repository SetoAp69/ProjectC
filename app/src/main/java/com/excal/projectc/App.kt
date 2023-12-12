package com.excal.projectc

import android.app.Application
import com.excal.projectc.data.di.networkModule
import com.excal.projectc.data.di.repositoryModule
import com.excal.projectc.data.di.roomModule
import com.excal.projectc.data.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(listOf( repositoryModule, networkModule, viewModelModule,  roomModule))
            androidFileProperties()
        }
    }

}