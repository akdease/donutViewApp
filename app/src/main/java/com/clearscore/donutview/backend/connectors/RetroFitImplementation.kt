package com.clearscore.donutview.backend.connectors

import com.clearscore.donutview.utilities.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroFitImplementation {

    private val okHttpClient = OkHttpClient.Builder().build()
    private val retrofit = Retrofit.Builder()
        .baseUrl(getBaseUrl())
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    private fun getBaseUrl() : String {
        return "https://" + Constants.DONUT_API_HOST
    }

    fun getRetrofit() : RetroFitApiService {
        return retrofit.create(RetroFitApiService::class.java)
    }

}