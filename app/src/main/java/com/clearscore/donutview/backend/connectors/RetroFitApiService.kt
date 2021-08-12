package com.clearscore.donutview.backend.connectors

import com.clearscore.donutview.backend.models.DonutDataModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.QueryMap

interface RetroFitApiService {

    @GET("/endpoint.json")
    suspend fun getDonutData(
        @HeaderMap headerMap: Map<String, String>,
        @QueryMap queryMap: Map<String, String>
    ): Response<DonutDataModel>

}