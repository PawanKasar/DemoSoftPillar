package com.example.kotlindemowithretrofit.presentor.controller.Utilities

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.widget.Toast

object CallingImportantMethod {

    public fun showToast(context: Context?, msg: String?) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }


    public fun showToastError(context: Context?) {
        Toast.makeText(context, "NO INTERNET CONNECTION", Toast.LENGTH_SHORT).show()
    }

    public fun hideKeyboard(ctx: Context) {
        val inputManager = ctx
            .getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        // check if no view has focus:
        val v = (ctx as Activity).currentFocus ?: return
        inputManager?.hideSoftInputFromWindow(v.windowToken, 0)
    }

}