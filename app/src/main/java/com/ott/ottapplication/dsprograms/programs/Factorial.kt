package com.ott.ottapplication.dsprograms.programs

class Factorial {

    fun findFactorial(n: Int): Int{
        var fact = 1
        if(n==1){
            return fact
        }else{
            fact = n* findFactorial(n-1)
        }
        return fact
    }
}