package com.solulab.assignment.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity
class CoinsData {

    @PrimaryKey
    @SerializedName("_id")
    @Expose
    var id: String = ""

    @SerializedName("price")
    @Expose
    var price: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("history")
    @Expose
    var history: String? = null

    @SerializedName("year")
    @Expose
    var year: String? = null

    @SerializedName("age")
    @Expose
    var age: String? = null

    @SerializedName("isGraded")
    @Expose
    var type: String? = null

    @SerializedName("isSold")
    @Expose
    var sold: String? = null

    @SerializedName("isCoin")
    @Expose
    var _isCoin: String? = null


    constructor(coinsModel: CoinsModel) {
        this.id = coinsModel._id
        this.price = coinsModel.price
        this.name = coinsModel.name
        this.history = coinsModel.history
        this.year = coinsModel.year
        this.age = coinsModel.age
        this.type = coinsModel.type
        this.sold = coinsModel.isSold
        this._isCoin = coinsModel.isCoin
    }

    constructor()


}