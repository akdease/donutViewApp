package com.clearscore.donutview.repositories

import com.clearscore.donutview.backend.connectors.RetroFitCallback
import com.clearscore.donutview.backend.connectors.RetroFitImplementation
import com.clearscore.donutview.backend.models.DonutDataModel

class DonutRepository : BaseRepository() {

    fun getDonutData(headerMap : HashMap<String, String>, queryMap : HashMap<String, String>, retroFitCallback: RetroFitCallback<DonutDataModel>) {
        //Logic can be added here to not get it from the server each time
        RetroFitImplementation().getDonutData(headerMap, queryMap, retroFitCallback)
    }

}