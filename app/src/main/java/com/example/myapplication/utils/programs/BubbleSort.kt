package com.example.myapplication.utils.programs

class BubbleSort : BaseSort {

    override fun sort(input: IntArray) {


        for (i in input.indices) {
            for (j in 0..input.size - i) {

                if (input[j] > input[j + 1]) {
                    val temp = input[j + 1]
                    input[j + 1] = input[j]
                    input[j] = temp
                    break
                }

            }
        }

        for (i in input.indices) {
            println("Sorted array is ${input[i]}")
        }
    }

}