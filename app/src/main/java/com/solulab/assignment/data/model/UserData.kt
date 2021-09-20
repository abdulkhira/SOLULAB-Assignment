package com.solulab.assignment.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
class UserData {

    @PrimaryKey
    @SerializedName("id")
    var id: String = ""

    @SerializedName("coinId")
    var coinId: String? = null

    @SerializedName("firstName")
    var firstName: String? = null

    @SerializedName("lastName")
    var lastName: String? = null

    constructor(userRS: UserRS) {
        this.id = userRS._id
        this.coinId = userRS.coinId
        this.firstName = userRS.firstName
        this.lastName = userRS.lastName
    }

    constructor()


}