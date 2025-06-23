package com.ott.ottapplication.ui.piechart

import android.os.Bundle
import com.ott.ottapplication.databinding.AcivityPiechartBinding
import com.ott.ottapplication.ui.BaseActivity

class PieChartActivity : BaseActivity<AcivityPiechartBinding>() {

    override fun getViewBinding(): AcivityPiechartBinding {
       return AcivityPiechartBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}