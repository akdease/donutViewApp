package com.clearscore.donutview

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.clearscore.donutview.R
import com.clearscore.donutview.activities.MainActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import java.util.regex.Pattern.matches

//import androidx.test.espresso.Espresso.click
//import androidx.test.espresso.Espresso.withId


@RunWith(AndroidJUnit4::class)
@LargeTest
class DonutUITest {

    private lateinit var stringToBetyped: String

    @get:Rule
    var activityRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun initValidString() {
        // Specify a valid string.
        stringToBetyped = "Espresso"
    }

    @Test
    fun test_RefreshButton() {
        onView(withId(R.id.btnRefresh))
            .perform(click())
        /*onView(withId(R.id.txtMax))
            .check(matches(isDisplayed()))*/
    }
}