package com.paycode.donutview

import com.clearscore.donutview.utilities.TimeManager
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.util.*

class TimeManagerTest {

    private lateinit var timeManager: TimeManager

    @Before
    fun setup() {
        timeManager = TimeManager()
    }

    @Test
    fun test_GetTimeDifferenceForTwoMinutes() {
        val oldDate = Calendar.getInstance()
        oldDate.set(Calendar.MINUTE, oldDate.get(Calendar.MINUTE) - 2)
        Assert.assertEquals(2, timeManager.getTimeDifference(oldDate.timeInMillis))
    }

    @Test
    fun test_GetTimeDifferenceForFourMinutes() {
        val oldDate = Calendar.getInstance()
        oldDate.set(Calendar.MINUTE, oldDate.get(Calendar.MINUTE) - 4)
        Assert.assertEquals(4, timeManager.getTimeDifference(oldDate.timeInMillis))
    }

    @Test
    fun test_GetTimeDifferenceForSixMinutes() {
        val oldDate = Calendar.getInstance()
        oldDate.set(Calendar.MINUTE, oldDate.get(Calendar.MINUTE) - 6)
        Assert.assertEquals(6, timeManager.getTimeDifference(oldDate.timeInMillis))
    }

}