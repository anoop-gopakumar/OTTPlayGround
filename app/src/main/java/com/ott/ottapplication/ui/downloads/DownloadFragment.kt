package com.ott.ottapplication.ui.downloads

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.ott.ottapplication.databinding.FragmentDownloadsBinding
import com.ott.ottapplication.ui.BaseFragment
import com.ott.ottapplication.ui.MusicService
import com.ott.ottapplication.ui.player.PlayerActivity
import com.ott.ottapplication.utils.ActivityLauncher
import com.ott.ottapplication.databinding.FragmentHomeBinding

class DownloadFragment : BaseFragment<FragmentDownloadsBinding>(FragmentDownloadsBinding::inflate) {

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

    private fun setupHome() {
        val homeViewModel = ViewModelProvider(this)[DownloadViewModel::class.java]
        homeViewModel.text.observe(viewLifecycleOwner) {}
    }
}