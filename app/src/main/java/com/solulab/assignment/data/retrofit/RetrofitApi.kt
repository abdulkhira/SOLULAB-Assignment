package com.solulab.assignment.data.retrofit

import com.solulab.assignment.data.model.*
import com.solulab.assignment.data.model.Response
import retrofit2.http.*


interface RetrofitApi {

    //get coin list
    @GET("coinlist")
    suspend fun getCoinsList(): Response<CoinRS>


}