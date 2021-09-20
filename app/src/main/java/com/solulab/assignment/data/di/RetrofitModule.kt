package com.solulab.assignment.data.di

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import com.google.gson.GsonBuilder
import com.solulab.assignment.BuildConfig
import com.solulab.assignment.data.repository.SplashRepository


val retrofitModule = module {
    single { provideRetrofit() }
    single { SplashRepository(get()) }

}

fun provideRetrofit(): Retrofit {
    val gson = GsonBuilder()
        .setLenient()
         .create()
    return Retrofit.Builder().baseUrl(BuildConfig.CUSTOM_BASE).client(provideOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create(gson)).build()
}

fun provideOkHttpClient(): OkHttpClient {
    val builder = OkHttpClient()
            .newBuilder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)

    if (BuildConfig.DEBUG) {
        val requestInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        builder.addNetworkInterceptor(requestInterceptor)
    }

    return builder.build()
}