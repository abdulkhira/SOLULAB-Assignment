package com.solulab.assignment.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.solulab.assignment.data.local.CoinDao
import com.solulab.assignment.data.local.CoinDatabase
import com.solulab.assignment.data.model.Resource
import com.solulab.assignment.data.viewmodels.SplashViewModel
import com.solulab.assignment.databinding.ActivitySplashBinding
import org.koin.android.viewmodel.ext.android.viewModel
import retrofit2.Response

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    lateinit var binding: ActivitySplashBinding
    val profileViewModel: SplashViewModel by viewModel()
    lateinit var coinDao: CoinDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        coinDao = CoinDatabase.getDatabase(this)!!.coinDao()!!
        getCoinsData()
        observeCoinsData()

    }

    private fun observeCoinsData() {
        profileViewModel.performToFetchCoinsObserver.observe(this, {
            when(it.status) {
                Resource.Status.LOADING -> {

                }
                Resource.Status.EMPTY -> {

                }
                Resource.Status.SUCCESS -> {
                    if (it.data != null) {
                        startActivity(Intent(this, MainActivity::class.java))
                    } else {
                        Toast.makeText(this, "Something Wrong!", Toast.LENGTH_SHORT).show()
                    }
                }
                Resource.Status.OFFLINE_ERROR -> {

                }
                Resource.Status.ERROR -> {
                    Toast.makeText(this, "" + it.error?.message, Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun getCoinsData() {
        profileViewModel.getCoinsList(coinDao)
    }

}