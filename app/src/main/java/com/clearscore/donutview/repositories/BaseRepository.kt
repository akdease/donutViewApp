package com.clearscore.donutview.repositories

import com.clearscore.donutview.utilities.Constants
import java.util.*

open class BaseRepository {

    fun shouldUseInternet(oldDate: Calendar?): Boolean {
        if (oldDate == null)
            return true

        val newDate = Calendar.getInstance()

        val diff: Long = newDate.timeInMillis - oldDate.timeInMillis
        val seconds = diff / 1000
        val minutes = seconds / 60

        return minutes >= Constants.API_CACHE_TIMEOUT_IN_MINUTES
    }

}