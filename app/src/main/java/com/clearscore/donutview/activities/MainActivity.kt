package com.clearscore.donutview.activities

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import app.futured.donut.DonutProgressView
import app.futured.donut.DonutSection
import com.clearscore.donutview.R
import com.clearscore.donutview.backend.models.DonutDataModel
import com.clearscore.donutview.viewModels.MainViewModel
import kotlinx.coroutines.Dispatchers

class MainActivity : BaseActivity() {

    private lateinit var viewModel: MainViewModel

    private lateinit var btnRefresh: Button
    private lateinit var donutView: DonutProgressView
    private lateinit var txtSore: TextView
    private lateinit var txtMax: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        setupObservers();
        viewModel?.getDonutData()
    }

    private fun initView() {
        viewModel = MainViewModel(this, Dispatchers.Main)

        btnRefresh = findViewById(R.id.btnRefresh)
        donutView = findViewById(R.id.donutView)
        txtSore = findViewById(R.id.txtSore)
        txtMax = findViewById(R.id.txtMax)

        btnRefresh.setOnClickListener { viewModel?.getDonutData() }
    }

    private fun setupObservers() {
        viewModel?.mutableDonutDataModel?.observe(this, {
            updateView(it)
        })

        viewModel?.errorMessage?.observe(this, {
            hideProgressDialog()
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })

        viewModel.loading?.observe(this, {
            if (it)
                showProgressDialog()
            else
                hideProgressDialog()
        })
    }

    private fun updateView(donutDataModel: DonutDataModel) {
        txtSore?.text = donutDataModel?.creditReportInfo?.score?.toString()
        txtMax?.text =
            getString(R.string.out_of) + " " + donutDataModel?.creditReportInfo?.maxScoreValue?.toString()

        val section1 = DonutSection(
            name = "section_1",
            color = Color.parseColor("#FB1D32"),
            amount = donutDataModel?.creditReportInfo?.score!!
        )

        donutView?.cap = donutDataModel?.creditReportInfo?.maxScoreValue
        donutView?.submitData(listOf(section1))
    }
}