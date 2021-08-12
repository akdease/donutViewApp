package com.paycode.donutview

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import com.clearscore.donutview.viewModels.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.*
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
/*@RunWith(AndroidJUnit4::class)
@LargeTest*/
class DonutDataTest {

    @ExperimentalCoroutinesApi
    private val testCoroutineDispatcher = TestCoroutineDispatcher()
    private val testCoroutineScope = TestCoroutineScope(testCoroutineDispatcher)

    private lateinit var context: Context

    @Before
    fun setup() {
        Dispatchers.setMain(testCoroutineDispatcher)
        context = InstrumentationRegistry.getInstrumentation().context
    }

    @After
    fun finish() {
        Dispatchers.resetMain()
        testCoroutineDispatcher?.cleanupTestCoroutines()
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getWeatherData() = runBlocking {
        val mainViewModel = MainViewModel(context, testCoroutineDispatcher)
        mainViewModel?.getDonutData()
        Assert.assertNotEquals(null, mainViewModel?.mutableDonutDataModel)
    }

    /*override fun apply(base: Statement?, description: Description?): Statement {
        TODO("Not yet implemented")
    }*/

}