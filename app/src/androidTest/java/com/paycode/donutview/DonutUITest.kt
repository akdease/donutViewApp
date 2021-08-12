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
import androidx.test.espresso.matcher.ViewMatchers.*
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

    @Test
    fun test_RefreshButton() {
        Thread.sleep(3000)

        onView(withId(R.id.btnRefresh))
            .perform(click())
        /*onView(withId(R.id.btnRefresh))
            .check(matches(withText("Verifying...")))*/
    }
}