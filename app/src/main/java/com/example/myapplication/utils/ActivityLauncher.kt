package com.example.myapplication.utils

import android.content.Context
import android.content.Intent

class ActivityLauncher {

    fun <T:Any> launchAct(context: Context, type: Class<T>) {
        val intent = Intent(context, type)
        context.startActivity(intent)
    }

}