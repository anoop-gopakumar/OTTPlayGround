package com.example.myapplication

import android.content.Context
import android.content.SharedPreferences

class Pref(val context: Context) {

    private val KEY = "BOOKMARK"
    private val PREF_NAME = "TempStorage"

    fun getToken(): String? {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).getString(KEY, "");
    }


}