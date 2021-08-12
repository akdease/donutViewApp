package com.clearscore.donutview.viewModels

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.clearscore.donutview.backend.models.DonutDataModel
import com.clearscore.donutview.repositories.DonutDataRepository
import kotlinx.coroutines.*

class MainViewModel(
    private val context: Context,
    private val coroutineDispatcher: CoroutineDispatcher
) : BaseViewModel() {

    private var headerMap = HashMap<String, String>()
    private var queryMap = HashMap<String, String>()
    private var donutRepository = DonutDataRepository()

    var errorMessage = MutableLiveData<String>()
    var mutableDonutDataModel = MutableLiveData<DonutDataModel>()
    var loading = MutableLiveData<Boolean>()
    private var job: Job? = null

    fun getDonutData() {
        loading?.value = true
        job = CoroutineScope(Dispatchers.IO).launch {
            val response = donutRepository?.getDonutData(
                context,
                headerMap,
                queryMap
            )
            withContext(coroutineDispatcher) {
                if (response?.isSuccessful === true)
                    mutableDonutDataModel?.postValue(response)
                else
                    onError("Error : ${response?.message} ")
                loading?.value = false
            }
        }
    }

    private fun onError(message: String) {
        errorMessage?.value = message
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}