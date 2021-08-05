package com.clearscore.donutview.activities

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import com.clearscore.donutview.R

open class BaseActivity : AppCompatActivity() {

    private lateinit var progressDialog: ProgressDialog

    fun showProgressDialog() {
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle(getString(R.string.app_name))
        progressDialog.setMessage(getString(R.string.loading))
        progressDialog.show()
    }

    fun hideProgressDialog() {
        if (progressDialog?.isShowing)
            progressDialog?.hide()
    }
}