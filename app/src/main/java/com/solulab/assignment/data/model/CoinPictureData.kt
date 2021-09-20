package com.solulab.assignment.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
class CoinPictureData {

    @PrimaryKey
    @SerializedName("coinsId")
    var coinsId: String = ""

    @SerializedName("front")
    var front: String? = null

    @SerializedName("key")
    var key: String? = null

    @SerializedName("sizeInMegaByte")
    var sizeInMegaByte: String? = null

    @SerializedName("url")
    var url: String? = null

}