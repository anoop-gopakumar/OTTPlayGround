package com.example.myapplication.utils.programs

import android.util.Log

class FindMostDuplicatedString {

    fun findMostDuplicated(inputString  : String){

        val frequencyMap = mutableMapOf<Char,Int>()

        for (char in inputString){
            frequencyMap[char] = frequencyMap.getOrDefault(char,0)+1
        }

        Log.d("TAG", "findMostDuplicated: ${frequencyMap}")

        var maxValue = 1
        var repeatedChar : Char? = null

        for((key,value ) in frequencyMap){
            Log.d("TAG", "key and value is : ${key} v: ${value}")

            if(value > maxValue){
                maxValue = value
                repeatedChar = key
            }
        }

        Log.d("TAG", "findMostDuplicated is : ${repeatedChar} MxValue : ${maxValue}")

    }
}