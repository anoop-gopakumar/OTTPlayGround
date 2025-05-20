package com.example.myapplication.utils.programs

class Triangle(b: Int, h: Int) : Shape {

    var b: Int? = b
    var h: Int? = h


    override fun area(): Int? {
         return (h?.let { b?.times(it) })?.div(2)
    }

    override fun volume(): Int {
        TODO("Not yet implemented")
    }
}