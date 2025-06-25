package com.ott.ottapplication.ui.home

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ott.ottapplication.databinding.FragmentHomeBinding
import com.ott.ottapplication.models.Videos
import com.ott.ottapplication.ui.BaseFragment
import com.ott.ottapplication.ui.MusicService
import com.ott.ottapplication.ui.details.DetailsActivity
import com.ott.ottapplication.ui.player.PlayerActivity
import com.ott.ottapplication.utils.ActivityLauncher
import com.ott.ottapplication.utils.CustomData

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    override fun onCreate() {
        setupHome()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setLists()

    }

    private fun setLists() {
        binding?.myList?.layoutManager = LinearLayoutManager(context)
        binding?.myList?.adapter = HomeAdapter().apply {
            setContent(CustomData.getData().videos)
            binding?.myList?.adapter = this
            setClickListener { result: Videos ->
                moveToDetails(result)
            }
        }
    }

    private fun moveToDetails(videos: Videos) {
        ActivityLauncher().launchAct(
            context as Activity,
            bundleOf(Pair("video", videos)),
            DetailsActivity::class.java
        )
    }

    private fun startMusicService() {
        activity?.startService(Intent(activity, MusicService::class.java))
    }

    private fun setupHome() {
        val homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        homeViewModel.text.observe(viewLifecycleOwner) {

        }
    }
}