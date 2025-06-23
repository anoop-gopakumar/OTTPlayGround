package com.ott.ottapplication.dsprograms.programs

import android.util.Log

class SecondLargest {

    private val inputArray = intArrayOf(3, 6, 4, 8, 10, 1, 7, 12)

    fun findSecondLargest(): Int {
        val largest = findLargest(inputArray)
        Log.d("", "Largest number is :${largest}")
        val secondArray = IntArray(10)

        for (i in inputArray.indices) {
            if (inputArray[i] != largest) {
                secondArray[i] = inputArray[i]
            }
        }

        val secondL = findLargest(secondArray)
        Log.d("", "Second largest number is :${secondL}")
        return secondL
    }

    private fun findLargest(input: IntArray): Int {
        var largest = 0
        for (i in input.indices) {
            if (largest < input[i]) {
                largest = input[i]
            }
        }
        return largest
    }

}