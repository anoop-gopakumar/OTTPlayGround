package com.example.myapplication.ui.home

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.ui.BaseFragment
import com.example.myapplication.ui.MusicService
import com.example.myapplication.ui.player.PlayerActivity
import com.example.myapplication.utils.ActivityLauncher

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    override fun onCreate() {
        setupHome()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.homeText?.text = "hello"
        setClickListener()
    }

    private fun setClickListener() {
        binding?.startServiceBtn?.setOnClickListener {
            startMusicService()
        }
        binding?.launchPlayBackBtn?.setOnClickListener {
            launchPlayBack()
        }
    }

    private fun startMusicService() {
        activity?.startService(Intent(activity, MusicService::class.java))
    }

    private fun launchPlayBack() {
        ActivityLauncher().launchAct(context as Activity, PlayerActivity::class.java)
    }

    private fun setupHome() {
        val homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        homeViewModel.text.observe(viewLifecycleOwner) {}
    }
}