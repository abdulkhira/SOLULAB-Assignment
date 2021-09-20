package com.solulab.assignment.data.model

import com.google.gson.annotations.SerializedName

data class Response<out T>(
    @SerializedName("result")
    val result: Int,
    @SerializedName("data")
    val `data`: T?,
    @SerializedName("msg")
    val msg: String,

)