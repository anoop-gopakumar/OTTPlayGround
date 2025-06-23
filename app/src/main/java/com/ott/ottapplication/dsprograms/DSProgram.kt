package com.ott.ottapplication.dsprograms

fun main() {
    val inputArray = intArrayOf(40, 850, 1500, 10, 34, 1, 67, 0, 80)
    // secondLargest(inputArray, 0)
    findSecondLargest(inputArray)
}

// The best algorithm time complexity O(n)
fun findSecondLargest(inputArray: IntArray) {
    var largest = Integer.MIN_VALUE
    var second = Integer.MIN_VALUE

    for (num in inputArray) {
        if (num > largest) {
            second = largest
            largest = num
        } else if (num < largest && num > second) {
            second = num
        }
    }

    println("The second largest is $second")
    println("The first largest is $largest")
}

fun secondLargest(inputArray: IntArray, count: Int) {
    val data = findLargest(inputArray)
    val secondArray = inputArray.filterNot { it == data }.toIntArray()
    val secondLargest = findLargest(secondArray)
    println("Se largest is $secondLargest")
}

fun findLargest(inputArray: IntArray): Int {
    var largest = Integer.MIN_VALUE
    for (i in inputArray.indices) {
        if (largest < inputArray[i]) {
            largest = inputArray[i]
        } else if ((inputArray.size < i + 1) && inputArray[i] < inputArray[i + 1]) {
            largest = inputArray[i + 1]
        }
    }
    return largest
}
