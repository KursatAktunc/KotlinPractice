package com.kotlin.practice.util

import android.content.Context
import android.widget.Toast
import dagger.hilt.android.qualifiers.ApplicationContext

class ToastHelper constructor(@ApplicationContext private val context: Context) {

    fun showToastShort(message: String?) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    fun showToastLong(message: String?) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}