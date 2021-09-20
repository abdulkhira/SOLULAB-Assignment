package com.solulab.assignment.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.solulab.assignment.data.model.CoinPictureData
import com.solulab.assignment.data.model.CoinsData
import com.solulab.assignment.data.model.ProfileData
import com.solulab.assignment.data.model.UserData
import io.reactivex.Flowable

@Dao
interface CoinDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCoinData(data: CoinsData)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCoinPictureData(data: CoinPictureData)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUserData(data: UserData)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProfileData(data: ProfileData)

    @Query("SELECT * FROM coinsdata")
    fun coinsData(): Flowable<List<CoinsData>>

    @Query("SELECT * FROM coinpicturedata WHERE coinsId=:consId AND front=:front")
    fun coinsPictureData(consId: String, front: String): CoinPictureData?

    @Query("SELECT * FROM userdata WHERE id =:id")
    fun userData(id: String): UserData?

    @Query("SELECT * FROM profiledata WHERE userId =:userId")
    fun profileData(userId: String): ProfileData?


}