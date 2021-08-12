package com.clearscore.donutview.utilities

import java.util.*

class TimeManager {

    fun getTimeDifference(oldDate: Long?): Long {
        if (oldDate == null)
            return 0;

        val todaysDate = Calendar.getInstance()
        val newDate: Long = todaysDate.timeInMillis

        val diff: Long = newDate - oldDate
        val seconds = diff / 1000
        val minutes = seconds / 60
        return minutes
    }

}