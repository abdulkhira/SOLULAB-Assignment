package com.solulab.assignment.data.model

import com.google.gson.annotations.SerializedName

data class CoinPictures(
    @SerializedName("front") val front: CoinPictureData,
    @SerializedName("back") val back: CoinPictureData? = null,
)