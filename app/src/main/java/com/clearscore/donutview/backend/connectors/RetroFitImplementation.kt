package com.clearscore.donutview.backend.connectors

import com.clearscore.donutview.backend.models.DonutDataModel
import com.clearscore.donutview.utilities.Constants
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.HeaderMap
import retrofit2.http.QueryMap

class RetroFitImplementation() {

    private val okHttpClient = OkHttpClient.Builder().build()
    private val retrofit = Retrofit.Builder()
        .baseUrl(getBaseUrl())
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()


    private fun getBaseUrl() : String {
        return "https://" + Constants.DONUT_API_HOST
    }

    private fun <T> enqueue(call: Call<T>, retroFitCallback: RetroFitCallback<T>)  {
        call.enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                retroFitCallback?.onResponse(call, response)
            }
            override fun onFailure(call: Call<T>, throwable: Throwable) {
                retroFitCallback?.onFailure(call, throwable)
            }
        })
    }

    fun getDonutData(@HeaderMap headerMap : Map<String, String>, @QueryMap queryMap : Map<String, String>, retroFitCallback: RetroFitCallback<DonutDataModel>) {
        val request = retrofit.create(RetroFitApi::class.java)
        val call = request.getDonutData(headerMap, queryMap)
        enqueue(call, retroFitCallback)
    }

}