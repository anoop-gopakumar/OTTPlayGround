package com.ott.ottapplication.ui.details

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.lifecycle.lifecycleScope
import com.ott.ottapplication.ui.states.GameViewModel
import com.ott.ottapplication.R
import com.ott.ottapplication.models.Videos
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class DetailsActivity : AppCompatActivity() {

    private val viewModel by viewModels<GameViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_home)

        val getContent = intent.getSerializableExtra("", )


      //  bundleOf(Pair("videos", videos)),
        collectData()
    }

    fun collectData(){
        lifecycleScope.launch(Dispatchers.IO) {
            viewModel.uiState.collectLatest { uiSate->
                when(uiSate.isGameOver){
                    true->{}
                    false -> {}
                }
            }
        }
    }
}