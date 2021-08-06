package com.clearscore.donutview.activities

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import app.futured.donut.DonutProgressView
import app.futured.donut.DonutSection
import com.clearscore.donutview.R
import com.clearscore.donutview.backend.connectors.RetroFitCallback
import com.clearscore.donutview.backend.models.DonutDataModel
import com.clearscore.donutview.viewModels.MainViewModel
import retrofit2.Call
import retrofit2.Response

class MainActivity : BaseActivity() {

    private lateinit var viewModel: MainViewModel

    private lateinit var btnRefresh: Button
    private lateinit var donut_view: DonutProgressView
    private lateinit var txtSore: TextView
    private lateinit var txtFooter: TextView

    private lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        requestData()
    }

    fun initView() {
        context = this
        viewModel = MainViewModel()

        btnRefresh = findViewById(R.id.btnRefresh)
        donut_view = findViewById(R.id.donut_view)
        txtSore = findViewById(R.id.txtSore)
        txtFooter = findViewById(R.id.txtFooter)

        btnRefresh.setOnClickListener{ requestData() }
    }

    fun requestData() {
        var retroFitCallback = object : RetroFitCallback<DonutDataModel> {
            override fun onResponse(call: Call<DonutDataModel>, response: Response<DonutDataModel>) {
                hideProgressDialog()
                updateView(response)
            }

            override fun onFailure(call: Call<DonutDataModel>, throwable: Throwable) {
                hideProgressDialog()
                Toast.makeText(context, throwable.message, Toast.LENGTH_LONG).show()
            }
        }

        viewModel.getDonutData(this, retroFitCallback)
    }

    fun updateView(response: Response<DonutDataModel>) {
        val donutDataModel : DonutDataModel? = response.body()

        txtSore?.text = donutDataModel?.creditReportInfo?.score?.toString()
        txtFooter?.text = getString(R.string.out_of) + " " + donutDataModel?.creditReportInfo?.maxScoreValue?.toString()

        val section1 = DonutSection(
            name = "section_1",
            color = Color.parseColor("#FB1D32"),
            amount = donutDataModel?.creditReportInfo?.score!!
        )

        donut_view.cap = donutDataModel?.creditReportInfo?.maxScoreValue
        donut_view.submitData(listOf(section1))

    }
}