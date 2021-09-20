package com.solulab.assignment.data.model

import com.google.gson.annotations.SerializedName

data class UserRS(
    @SerializedName("_id") val _id: String,
    @SerializedName("coinId") val coinId: String,
    @SerializedName("firstName") val firstName: String,
    @SerializedName("lastName") val lastName: String,
    @SerializedName("profilePic") val profilePic: ProfileData,
)