package com.solulab.assignment.data.model

import com.google.gson.annotations.SerializedName

data class CoinsModel(
    @SerializedName("_id") var _id: String,
    @SerializedName("price") var price: String,
    @SerializedName("name") var name: String,
    @SerializedName("history") var history: String,
    @SerializedName("year") var year: String,
    @SerializedName("age") var age: String,
    @SerializedName("isGraded") var type: String,
    @SerializedName("isSold") var isSold: String,
    @SerializedName("isCoin") var isCoin: String,
    @SerializedName("pictures") var pictures: CoinPictures? = null,
    @SerializedName("userId") var userId: UserRS? = null,
)