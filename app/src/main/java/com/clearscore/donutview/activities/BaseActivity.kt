package com.clearscore.donutview.activities

import android.app.ProgressDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.clearscore.donutview.R

open class BaseActivity : AppCompatActivity() {

    private lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        progressDialog = ProgressDialog(this)
    }

    fun showProgressDialog() {
        if (progressDialog?.isShowing)
            return

        progressDialog?.setTitle(getString(R.string.app_name))
        progressDialog?.setMessage(getString(R.string.loading))
        progressDialog?.show()
    }

    fun hideProgressDialog() {
        if (progressDialog?.isShowing)
            progressDialog?.hide()
    }
}