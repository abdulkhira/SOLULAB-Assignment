package com.solulab.assignment.data.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.solulab.assignment.data.local.CoinDao
import com.solulab.assignment.data.model.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainViewModel : ViewModel() {

    private val performToFetchCoinsList = MutableLiveData<List<CoinsModel>>()
    private var disposable: Disposable? = null

    fun getCoinsList(coinDao: CoinDao): LiveData<List<CoinsModel>> {
        disposable = coinDao.coinsData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { value: List<CoinsData> ->
                val coinsModels: ArrayList<CoinsModel> = ArrayList()
                if (value.isNotEmpty()) {
                    for (coinsData in value) {

                        val coinsPictureData = coinDao.coinsPictureData(coinsData.id, "0")
                        val coinsPictureDataFront = coinDao.coinsPictureData(coinsData.id, "1")
                        var coinPictures : CoinPictures? = null

                        Log.e("tag", "   = = = coinsData.id = = " + coinsData.id)


                        if (coinsPictureDataFront != null) {
                            coinPictures = CoinPictures(coinsPictureDataFront, coinsPictureData)
                        }

                        val userData = coinDao.userData(coinsData.id)
                        var profileData: ProfileData?
                        var userRS: UserRS? = null
                        if (userData != null) {
                            profileData = coinDao.profileData(userData.id)
                            userRS = UserRS(userData.id, userData.coinId.toString(), userData.firstName.toString(),
                                userData.lastName.toString(), profileData!!
                            )
                        }


                        val coinsModel = CoinsModel(coinsData.id, coinsData.price.toString(), coinsData.name.toString(),
                            coinsData.history.toString(), coinsData.year.toString(), coinsData.age.toString(),
                            coinsData.type.toString(), coinsData.sold.toString(), coinsData._isCoin.toString(),
                            coinPictures, userRS
                        )
                        coinsModels.add(coinsModel)
                    }
                }
                performToFetchCoinsList.value = coinsModels
            }

        return performToFetchCoinsList
    }

}