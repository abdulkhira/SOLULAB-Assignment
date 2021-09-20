package com.solulab.assignment.data.repository

import com.solulab.assignment.data.retrofit.RetrofitApi
import retrofit2.Retrofit

class SplashRepository(retrofit: Retrofit) {
    private val services = retrofit.create(RetrofitApi::class.java)
    suspend fun getCoinsList() = services.getCoinsList()
}