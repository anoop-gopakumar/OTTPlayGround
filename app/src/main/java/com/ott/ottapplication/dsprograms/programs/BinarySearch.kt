package com.ott.ottapplication.dsprograms.programs

class BinarySearch {

    fun binarySearchInArray(key : Int):Int {

        val sArray = intArrayOf(10, 20, 30, 40, 50, 60, 70, 80, 90)

        var low = 0
        var high = sArray.size - 1

        println("Low is ${low} and high is ${high}");

        while (low <= high) {

            var mid = (low + high) / 2
            println("mid is ${mid}");

            if (sArray[mid] == key) {
                return mid
            } else if (sArray[mid] < key) {
                low = mid + 1
            } else if (sArray[mid] > key) {
                high = mid - 1
            }
        }

        return -1

    }

}