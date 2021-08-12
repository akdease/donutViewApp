package com.clearscore.donutview.utilities

import java.util.*

class TimeManager {

    fun getTimeDifference(start: Int, end: Int): Int {
        return 0;
    }

    fun getTodaysDate(): Calendar {
        return Calendar.getInstance();
    }

    fun createDateFromLong(milliSeconds: Long): Calendar {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = milliSeconds
        return calendar
    }

}