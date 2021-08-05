package com.clearscore.donutview.viewModels

import com.clearscore.donutview.activities.BaseActivity
import com.clearscore.donutview.backend.connectors.RetroFitCallback
import com.clearscore.donutview.backend.models.DonutDataModel
import com.clearscore.donutview.repositories.DonutRepository

class MainViewModel {

    private var headerMap : HashMap<String, String>
    private var queryMap : HashMap<String, String>
    private var donutRepository : DonutRepository

    constructor() {
        headerMap = HashMap()
        queryMap = HashMap()
        donutRepository = DonutRepository()
    }

    fun getDonutData(baseActivity: BaseActivity, retroFitCallback: RetroFitCallback<DonutDataModel>) {
        baseActivity?.showProgressDialog();
        donutRepository?.getDonutData(headerMap, queryMap, retroFitCallback);
    }
}