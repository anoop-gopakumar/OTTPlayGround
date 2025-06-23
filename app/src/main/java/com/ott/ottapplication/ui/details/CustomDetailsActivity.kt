package com.ott.ottapplication.ui.details

import android.os.Bundle
import com.ott.ottapplication.databinding.FragmentHomeBinding
import com.ott.ottapplication.ui.BaseActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class CustomDetailsActivity : BaseActivity<FragmentHomeBinding>() {

    override fun getViewBinding(): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val scope = CoroutineScope(Job() + Dispatchers.IO)
        scope.launch {
            fetchData()
        }
    }

    override fun onStart() {
        super.onStart()


    }

    private fun fetchData(): String {
        val data = ""
        Thread.sleep(1000)
        return data;
    }




}