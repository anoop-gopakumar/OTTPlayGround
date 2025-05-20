package com.example.myapplication.utils.programs

class Tree {

    fun printIncrementTree(count : Int){
        val intArray = IntArray(10)
        for(i in 0..count) {
            print("*");
        }
    }

    fun printDecrementTree(count : Int){
        var tempCount = count
        for(i in 0..count) {
            for(j in tempCount downTo 0){
                print("*")
                if(j ==0){
                    println()
                    tempCount--
                }
            }
        }
    }

}