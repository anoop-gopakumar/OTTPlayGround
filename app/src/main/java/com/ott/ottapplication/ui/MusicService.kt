package com.ott.ottapplication.ui

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.os.Message
import android.widget.Toast

class MusicService : Service() {

    private var serviceHandler: ServiceHandler? = null

    private inner class ServiceHandler(looper: Looper) : Handler(looper) {
        override fun handleMessage(msg: Message) {
            try {
                Thread.sleep(1000)
            } catch (e: InterruptedException) {
                Thread.currentThread().interrupt()
            }
            stopSelf(msg.arg1)
        }
    }


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        serviceHandler = ServiceHandler(looper = Looper.getMainLooper())
        serviceHandler?.obtainMessage().also { msg ->
            msg?.arg1 = startId
            if (msg != null) {
                serviceHandler?.sendMessage(msg)
            }
        }
        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onDestroy() {
        Toast.makeText(this, "Task Completed", Toast.LENGTH_SHORT).show()
    }

}