package com.example.myapplication.utils.programs

class Generic {

    init {
        val inlineTut =  InlineTut()
        inlineTut.guide()

        inlineFunc {
            print("Ca;lling inline function")
        }
        inlineFunc {
            print("Ca;lling inline function")
        }
        inlineFunc {
            print("Ca;lling inline function")
        }


        var fn:(a:Int,b:Int) -> Int = ::sum
        fn(10,20)

    }

    fun sum(a:Int, b:Int):Int{
        return a+b
    }

    inline fun inlineFunc(fn:()->Unit){
        fn()
        println("Code inside inline")
    }

    fun callMe(fn:()->Unit){
        fn()
    }

}