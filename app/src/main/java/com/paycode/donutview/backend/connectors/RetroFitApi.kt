package com.paycode.donutview.backend.connectors

import com.paycode.donutview.backend.models.DonutDataModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.QueryMap

interface RetroFitApi {

    @GET("/endpoint.json")
    fun getDonutData(@HeaderMap headerMap : Map<String, String>, @QueryMap queryMap : Map<String, String>) : Call<DonutDataModel>

}