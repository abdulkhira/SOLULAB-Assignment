package com.solulab.assignment.data.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.solulab.assignment.data.local.CoinDao
import com.solulab.assignment.data.model.*
import com.solulab.assignment.data.repository.SplashRepository
import kotlinx.coroutines.launch
import java.net.UnknownHostException

class SplashViewModel(private val splashRepository: SplashRepository) : ViewModel() {

    private val performToFetchCoins = MutableLiveData<Resource<CoinRS>>()
    val performToFetchCoinsObserver: LiveData<Resource<CoinRS>>
        get() = performToFetchCoins

    fun getCoinsList(coinDao: CoinDao) {
        viewModelScope.launch {
            try {
                performToFetchCoins.value = Resource.loading()
                val response = splashRepository.getCoinsList()
                if (response.data != null) {
                    insertDataIntoDB(response.data, coinDao)
                } else {
                    performToFetchCoins.value = Resource.empty()
                }
            } catch (e: Exception) {
                Log.e("tag", " = = loginUser = =  " + e.message)
                if (e is UnknownHostException) {
                    performToFetchCoins.value = Resource.offlineError()
                } else {
                    performToFetchCoins.value = Resource.error(e)
                }
            }
        }
    }

    private fun insertDataIntoDB(data: CoinRS, coinDao: CoinDao) {
        for (coinRs in data.list) {

            val coinsData = CoinsData(coinRs)
            coinDao.insertCoinData(coinsData)

            if (coinRs.pictures != null) {
                Log.e("tag", " = = coinRs._id == " + coinRs._id)
                val coinPictureData = coinRs.pictures!!.back
                coinPictureData!!.coinsId = coinRs._id
                coinPictureData.front = "0"
                coinDao.insertCoinPictureData(coinPictureData)

                val coinPictureData2 = coinRs.pictures!!.front
                coinPictureData2.coinsId = coinRs._id
                coinPictureData2.front = "1"
                coinDao.insertCoinPictureData(coinPictureData2)
            }

            if (coinRs.userId != null) {
                val userData = UserData(coinRs.userId!!)
                coinDao.insertUserData(userData)

                val profileData = coinRs.userId!!.profilePic
                profileData.userId = coinRs.userId!!._id
                coinDao.insertProfileData(profileData)
            }
        }
        performToFetchCoins.value = Resource.success(data)
    }


}