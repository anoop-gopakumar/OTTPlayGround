package com.ott.ottapplication.dsprograms.programs

//LTIMindtree interview questin
class Programs {

    init {
        val array = intArrayOf(11, 15,2, 7)
        val indices =  findIndices(array)
        println(" Indices for the array is ${indices}")
    }

    private fun findIndices(array: IntArray): List<Int> {
        //Find sum
        var listIndexes = ArrayList<Int>()

        for (i in 0..<array.size - 1) {
            for (j in i+1..<array.size-1) {
                if (array[i] + array[j] == 9) {

                    listIndexes.add(i)
                    listIndexes.add(j)

                    return listIndexes
                }
            }
        }
        return listIndexes

    }
}