package com.example.myapplication.ui.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class DetailsViewModel : ViewModel() {

    private var data = MutableLiveData<String>()

    fun loadData() {
        viewModelScope.launch {
            loadDetailsInfo()
        }
    }

    fun updateBookMarks() {


        viewModelScope.launch(
            Dispatchers.Main
        ) {
            val data = async {
                getLastBookMark()
            }.await()

        }


    }

    suspend fun loadDetailsInfo() {
        //Please replace with real API
        delay(5000)
    }


    suspend fun getLastBookMark(): Int {
        //in mills
        return 20000
    }

    data class BookMarkData(val duration: Int) {}

}