package com.ott.ottapplication.utils

import android.content.Context
import android.content.Intent
import android.os.Bundle

class ActivityLauncher {

    fun <T:Any> launchAct(context: Context, type: Class<T>) {
        val intent = Intent(context, type)
        context.startActivity(intent)
    }

    fun <T:Any> launchAct(context: Context, bundle: Bundle, type: Class<T>) {
        val intent = Intent(context, type)
        intent.putExtras(bundle)
        context.startActivity(intent)
    }

}