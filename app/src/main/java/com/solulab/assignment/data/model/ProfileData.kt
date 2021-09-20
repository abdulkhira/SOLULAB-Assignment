package com.solulab.assignment.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
class ProfileData {

    @PrimaryKey
    @SerializedName("userId")
    var userId: String = ""

    @SerializedName("sizeInMegaByte")
    var sizeInMegaByte: String? = null

    @SerializedName("url")
    var url: String? = null

}
