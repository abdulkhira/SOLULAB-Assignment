package com.solulab.assignment.data.model

import com.google.gson.annotations.SerializedName

data class CoinRS(
    @SerializedName("totalItems") val totalItems: Int,
    @SerializedName("startIndex") val startIndex: Int,
    @SerializedName("itemsPerPage") val itemsPerPage: Int,
    @SerializedName("list") val list: ArrayList<CoinsModel>,
)