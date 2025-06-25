package com.ott.ottapplication.utils

import android.content.Context
import com.ott.ottapplication.R

class StringHandler(private val context: Context) {

    fun getName(): String {
        return context.getString(R.string.app_name);
    }

    fun getText() : String{
        return context.getString(R.string.title_sports)
    }

}