package com.solulab.assignment

import android.app.Application
import com.solulab.assignment.data.di.viewModelModule
import com.solulab.assignment.data.di.appModule
import com.solulab.assignment.data.di.retrofitModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SolulabAssignment : Application() {

    companion object {
        lateinit var instance: SolulabAssignment
    }


    override fun onCreate() {
        super.onCreate()

        instance = this
        startKoin {
            androidContext(this@SolulabAssignment)
            modules(listOf(appModule, retrofitModule, viewModelModule))
        }


    }

}