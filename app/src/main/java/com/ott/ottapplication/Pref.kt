package com.ott.ottapplication

import android.content.Context

class Pref(val context: Context) {

    private val KEY = "BOOKMARK"
    private val PREF_NAME = "TempStorage"

    fun getToken(): String? {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).getString(KEY, "");
    }


}