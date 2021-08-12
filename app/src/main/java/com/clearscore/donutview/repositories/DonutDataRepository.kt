package com.clearscore.donutview.repositories

import android.content.Context
import com.clearscore.donutview.backend.connectors.RetroFitImplementation
import com.clearscore.donutview.backend.models.DonutDataModel
import com.clearscore.donutview.utilities.StorageManager
import retrofit2.Response
import java.util.*
import kotlin.collections.HashMap

class DonutDataRepository : BaseRepository() {

    private val retroFitImplementation = RetroFitImplementation()
    private val storageManager = StorageManager()
    private var lastCallDate: Calendar? = null

    suspend fun getDonutData(
        context: Context,
        headerMap: HashMap<String, String>,
        queryMap: HashMap<String, String>
    ): DonutDataModel? {
        if (shouldUseInternet(lastCallDate)) {
            return runCallAndCacheResponse(context, headerMap, queryMap)
        } else {
            val obj: Object? =
                storageManager?.getObjectByKey(context, DonutDataModel::class.java.canonicalName)
            return obj as? DonutDataModel
        }
    }

    suspend fun runCallAndCacheResponse(
        context: Context, headerMap: HashMap<String, String>,
        queryMap: HashMap<String, String>
    ): DonutDataModel? {
        val response: Response<DonutDataModel> = retroFitImplementation?.getRetrofit()?.getDonutData(headerMap, queryMap)

        val donutDataModel = response?.body() as DonutDataModel
        donutDataModel?.isSuccessful = response?.isSuccessful
        donutDataModel?.message = response?.message()

        if (donutDataModel?.isSuccessful) {
            lastCallDate = Calendar.getInstance()
            storageManager?.saveObjectByKey(
                context,
                donutDataModel as Object,
                DonutDataModel::class.java.canonicalName
            )
        }

        return donutDataModel
    }
}