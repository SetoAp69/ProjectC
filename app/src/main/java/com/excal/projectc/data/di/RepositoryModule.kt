package com.excal.projectc.data.di
import com.excal.projectc.Repository
import com.excal.projectc.data.remote.RemoteRepository
import com.excal.projectc.data.roomdatabase.LocalRepository
import org.koin.dsl.module
val repositoryModule= module {
    single{ LocalRepository(get()) }
    single{ RemoteRepository(get()) }
    single{ Repository(get(), get()) }

}