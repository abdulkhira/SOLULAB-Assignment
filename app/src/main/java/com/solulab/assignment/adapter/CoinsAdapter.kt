package com.solulab.assignment.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.solulab.assignment.data.model.CoinsModel
import com.solulab.assignment.databinding.ItemCoinsBinding
import android.graphics.BitmapFactory

import android.graphics.Bitmap
import java.io.BufferedInputStream
import java.io.InputStream
import java.net.URL
import android.os.AsyncTask
import android.util.Log
import com.solulab.assignment.R
import com.squareup.picasso.Picasso
import java.lang.Exception


class CoinsAdapter(private var listModels: ArrayList<CoinsModel>) :
    RecyclerView.Adapter<CoinsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCoinsBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val coinsModel = listModels[holder.adapterPosition]

        holder.binding.txtCoinTitle.text = coinsModel.name

        if (coinsModel.pictures != null) {
            Log.e("tag"," = = coinsModel.pictures!!.front.url ==  " + coinsModel.pictures!!.front!!.url)
//            val inputStream: InputStream = URL(coinsModel.pictures!!.front.url).content as InputStream
//            val bufferedInputStream = BufferedInputStream(inputStream)
//            val bmp = BitmapFactory.decodeStream(bufferedInputStream)
            Picasso.get().load(coinsModel.pictures!!.front.url).into(holder.binding.imgCoin)
        } else {
            Picasso.get().load(R.mipmap.ic_launcher).into(holder.binding.imgCoin)
        }

    }

    override fun getItemCount(): Int {
        return listModels.size
    }

    class ViewHolder(var binding: ItemCoinsBinding) : RecyclerView.ViewHolder(
        binding.root
    )


}