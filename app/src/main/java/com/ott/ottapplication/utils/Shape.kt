package com.ott.ottapplication.utils

sealed class Shape {

    class Circle(var radius: Int) : Shape()

    class Square(var side: Int) : Shape()

    class Rectangle(var length: Int, var breadth: Int) : Shape()

    data object Rect : Shape()


}