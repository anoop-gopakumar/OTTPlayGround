package com.example.myapplication.utils

import android.util.Log

object Utils {

    fun findMostDuplicated(inputString  : String){

        val frequesncyMap = mutableMapOf<Char,Int>()


        for (char in inputString){
            frequesncyMap[char] = frequesncyMap.getOrDefault(char,0)+1
        }

        Log.d("TAG", "findMostDuplicated: ${frequesncyMap}")

        var maxValue = 1
        var repeatedChar : Char? = null

        for((key,value ) in frequesncyMap){
            Log.d("TAG", "key and value is : ${key} v: ${value}")

            if(value > maxValue){
                maxValue = value
                repeatedChar = key
            }
        }

        Log.d("TAG", "findMostDuplicated is : ${repeatedChar} MxValue : ${maxValue}")

    }

}



