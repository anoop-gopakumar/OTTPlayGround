package com.example.myapplication.ui.piechart

import android.os.Bundle
import com.example.myapplication.databinding.AcivityPiechartBinding
import com.example.myapplication.ui.BaseActivity

class PieChartActivity : BaseActivity<AcivityPiechartBinding>() {

    override fun getViewBinding(): AcivityPiechartBinding {
       return AcivityPiechartBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}