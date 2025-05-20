package com.example.myapplication.utils

import android.content.Context
import com.example.myapplication.R

class StringHandler(private val context: Context) {

    fun getName(): String {
        return context.getString(R.string.app_name);
    }

    fun getText() : String{
        return context.getString(R.string.title_dashboard)
    }

}