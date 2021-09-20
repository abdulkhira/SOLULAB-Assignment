package com.solulab.assignment.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.solulab.assignment.R
import com.solulab.assignment.adapter.CoinsAdapter
import com.solulab.assignment.data.local.CoinDao
import com.solulab.assignment.data.local.CoinDatabase
import com.solulab.assignment.data.model.CoinsModel
import com.solulab.assignment.data.viewmodels.MainViewModel
import com.solulab.assignment.data.viewmodels.SplashViewModel
import com.solulab.assignment.databinding.ActivityMainBinding
import com.solulab.assignment.databinding.ActivitySplashBinding
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    val mainViewModel: MainViewModel by viewModel()
    lateinit var coinDao: CoinDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        coinDao = CoinDatabase.getDatabase(this)!!.coinDao()!!

        getCoinsData()
    }

    private fun getCoinsData() {
        mainViewModel.getCoinsList(coinDao).observe(this, {
            val coinsAdapter = CoinsAdapter(it as ArrayList<CoinsModel>)
            binding.coinsRecyclerView.layoutManager = GridLayoutManager(this, 3)
            binding.coinsRecyclerView.adapter = coinsAdapter
        })
    }

}