package com.clearscore.donutview.backend.connectors

import retrofit2.Call
import retrofit2.Response

interface RetroFitCallback<T> {
    fun onResponse(call: Call<T>, response: Response<T>)
    fun onFailure(call: Call<T>, t: Throwable)
}