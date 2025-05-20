package com.example.myapplication.utils.programs

class Rectangle(private val l : Int, private val b:Int) : Shape {

    override fun area(): Int {

        println("Area of rectangle is ${l*b}")
        return l*b
    }

    override fun volume(): Int {
        TODO("Not yet implemented")
    }
}