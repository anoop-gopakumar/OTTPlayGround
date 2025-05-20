package com.example.myapplication.ui.details

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.GameViewModel
import com.example.myapplication.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class DetailsActivity : AppCompatActivity() {

    private val viewModel by viewModels<GameViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_home)
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