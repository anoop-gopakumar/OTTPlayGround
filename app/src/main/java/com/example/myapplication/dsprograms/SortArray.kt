package com.example.myapplication

import kotlin.math.abs

fun main() {
    val unsortedArray = intArrayOf(7, 12, 4, 233, 8, 13, 5, 9)
    //sortArray(unsortedArray)
//    println("Unsorted array")
//    unsortedArray.forEach {
//        println(it)
//    }
//    mergeSort(unsortedArray)
//
//    println("Sorted array")
//    unsortedArray.forEach {
//        println(it)
//    }
    val sharedResource = SharedResource()

    val myThread1 = Thread {

        sharedResource.increment()
    }
    myThread1.start()

    val myThread2 = Thread { sharedResource.increment() }
    myThread2.start()


    // Create multiple threads to increment the counter concurrently
    //  val thread1 = Thread { sharedResource.increment() }
    //  val thread2 = Thread { sharedResource.increment() }

    //  thread1.start()
    //  thread2.start()

}

class MyThread(private var count: Int, private var id: Int, function: () -> Unit) : Thread() {

    var threadId: Int = id


    override fun run() {


        val lock = Any()
        synchronized(lock) {

            while (count < 10) {
                count++
                println("Thread id is $threadId Count is : $count")
                sleep(1000)
            }
        }
    }
}

class SharedResource {
    private var counter = 0

    fun increment() {
        synchronized(this) {
        while (counter < 10) {
            counter++
            println("Incremented counter: $counter")
           }
         }
    }
}


private fun mergeSort(array: IntArray) {

    if (array.size < 2) return

    val mid = array.size / 2
    val left = IntArray(mid)
    val right = IntArray(array.size - mid)

    for (i in 0..<mid)
        left[i] = array[i]

    for (i in mid..<array.size - 1) {
        right[abs(mid - i)] = array[i]
    }

    mergeSort(left)
    mergeSort(right)

    merge(array, left, right)

}

private fun merge(array: IntArray, left: IntArray, right: IntArray) {

    var j = 0;
    var i = 0;
    var k = 0;

    while (i < left.size && j < right.size) {
        if (left[i] <= right[j]) {
            array[k++] = left[i++]
        } else {
            array[k++] = right[j++]
        }
    }

    while (i < left.size)
        array[k++] = left[i++];
    while (j < right.size)
        array[k++] = right[j++];

}

private fun sortArray(unsortedArray: IntArray) {
    for (i in unsortedArray.indices) {
        for (j in unsortedArray.indices) {
            if (j < unsortedArray.size - 1) {
                if (unsortedArray[j] > unsortedArray[j + 1]) {
                    val temp = unsortedArray[j]
                    unsortedArray[j] = unsortedArray[j + 1]
                    unsortedArray[j + 1] = temp
                }
            }
        }
    }

    unsortedArray.forEach {
        println("Sorted array is $it")
    }

}


