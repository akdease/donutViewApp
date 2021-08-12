package com.clearscore.donutview.repositories

import com.clearscore.donutview.utilities.Constants
import com.clearscore.donutview.utilities.TimeManager
import java.util.*

open class BaseRepository {

    fun shouldUseInternet(oldDate: Calendar?): Boolean {
        if (oldDate == null)
            return true

        return TimeManager().getTimeDifference(oldDate?.timeInMillis) >= Constants.API_CACHE_TIMEOUT_IN_MINUTES
    }

}