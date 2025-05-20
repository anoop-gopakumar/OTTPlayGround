package com.example.myapplication.utils

import android.content.Context
import android.content.Intent
import kotlin.reflect.KClass

class ActLauncher {

    fun <T:Any> launchAct(context: Context, type: Class<T>) {
        val intent = Intent(context, type)
        context.startActivity(intent)
    }

}