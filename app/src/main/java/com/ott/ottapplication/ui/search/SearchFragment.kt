package com.ott.ottapplication.ui.search

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.ott.ottapplication.ui.BaseFragment
import com.ott.ottapplication.ui.MusicService
import com.ott.ottapplication.ui.player.PlayerActivity
import com.ott.ottapplication.utils.ActivityLauncher
import com.ott.ottapplication.databinding.FragmentHomeBinding
import com.ott.ottapplication.databinding.FragmentSearchBinding

class SearchFragment : BaseFragment<FragmentSearchBinding>(FragmentSearchBinding::inflate) {

    override fun onCreate() {
        setupHome()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.homeText?.text = "hello"
        setClickListener()
    }

    private fun setClickListener() {
    }

    private fun startMusicService() {
        activity?.startService(Intent(activity, MusicService::class.java))
    }

    private fun launchPlayBack() {
        ActivityLauncher().launchAct(context as Activity, PlayerActivity::class.java)
    }

    private fun setupHome() {
        val homeViewModel = ViewModelProvider(this)[SearchViewModel::class.java]
        homeViewModel.text.observe(viewLifecycleOwner) {}
    }
}