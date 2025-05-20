package com.example.myapplication.utils.programs

class Common(var type: Int) {

    private var shape : Shape? = null


    fun getReturnType(x:Int,y:Int) : Shape? {

        when(type){
            1-> {
                shape = Triangle(x,y);
            }

            2->{
                shape = Rectangle(x,y);
            }
        }

        return shape

    }

}