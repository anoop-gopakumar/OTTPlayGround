fun main() {

    RadixSort().apply {
        val inputArray = intArrayOf(802, 70, 170, 75, 45, 90, 180, 405, 66)
        println("Radix sort ")
        println("Sorted list is ")
        sort(inputArray).forEach {
            println(" $it ")
        }
    }

//    CountSort().apply {
//        println(" Counting sort")
//        println( "Sorted list is")
//    }

}

interface SortingTechnique {

    fun sort(inputArray: IntArray): IntArray

}

//
//class CountSort : SortingTechnique{
//
////    override fun sort(inputArray: IntArray): IntArray {
////
////
////    }
//
//}





class RadixSort : SortingTechnique {

    override fun sort(inputArray: IntArray): IntArray {

        val largest = findLargest(inputArray)
        val dpC = extractDigits(largest)

        val x =  inputArray[6]++

        val y = inputArray[6]
        println("Value of x is  : $x")
        println("Value of y is  : $y")

        // Radix sort uses counting sort

        for (i in inputArray.indices) {
            if (i + 1 < inputArray.size && inputArray[i] < inputArray[i + 1]) {
                val temp = inputArray[i]
                inputArray[i + 1] = inputArray[i]
                inputArray[i] = temp
            }
        }

        return inputArray
    }

    private fun findLargest(inputArray: IntArray): Int {
        var largest = Int.MIN_VALUE
        for (num in inputArray) {
            if (largest < num) {
                largest = num
            }
        }
        println("Largest is $largest")
        return largest
    }

    private fun extractDigits(num: Int): Int {
        var number = num
        var count = 0
        while (number > 0) {
            val digit = number % 10
            println(digit)
            number /= 10
            count++
        }
        println("Number is $number")
        return count
    }

}