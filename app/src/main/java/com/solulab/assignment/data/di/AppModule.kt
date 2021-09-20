package com.solulab.assignment.data.di

import com.google.gson.Gson
import org.koin.dsl.module

val appModule = module {

    single {
        Gson()
    }


}