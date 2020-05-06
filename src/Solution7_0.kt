class Solution7_0 {
    //反转int值，注意溢出
    fun reverse(num: Int): Int {
        var start = System.nanoTime()
        val isNegative = num < 0
        var number = if (isNegative) -num else num
        println("1.0: "+(System.nanoTime() - start))
        start = System.nanoTime()
        val length = "$number".length
        println("1.1: "+(System.nanoTime() - start))
        start = System.nanoTime()
        val arr = Array(length) { 0 } //等同于 Array(length, {0})， 最后一个入参是lambda表达式的时候，一般写到外面，比较好看
        for (i in 0 until length) {
            arr[i] = number % 10
            number /= 10
        }

        println("1.2: "+(System.nanoTime() - start))
        start = System.nanoTime()
        number = 0

        //累加到剩最高位不加，判断溢出
        for (i in 0 until length-1) {
            number = number * 10 + arr[i]
        }

        if((Int.MAX_VALUE - arr[0]) / 10 >= number ){
            println("2.1: "+(System.nanoTime() - start))
            return if(isNegative) -(number * 10 + arr[length-1]) else number * 10 + arr[length-1]
        }
        println("2.2: "+(System.nanoTime() - start))

        return 0
    }
}