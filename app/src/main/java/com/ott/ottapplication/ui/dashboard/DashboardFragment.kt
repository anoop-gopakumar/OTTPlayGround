package com.ott.ottapplication.ui.dashboard

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.ott.ottapplication.databinding.FragmentDashboardBinding
import com.ott.ottapplication.ui.BaseFragment

class DashboardFragment :
    BaseFragment<FragmentDashboardBinding>(FragmentDashboardBinding::inflate) {

    private var dashboardViewModel: DashboardViewModel? = null

    override fun onCreate() {
        dashboardViewModel =
            ViewModelProvider(this)[DashboardViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding?.button?.text = "Load here";
        //val textView: TextView = binding?.textDashboard!!
        dashboardViewModel?.text?.observe(viewLifecycleOwner) {
            //  textView.text = it
        }
    }

}