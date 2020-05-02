class Solution7_0 {
    fun reverse(num: Int): Int {
        val isNegative = num < 0
        var number = if (isNegative) num * -1 else num
        val length = "$number".length
        val arr = Array(length) { 0 } //等同于 Array(length, {0})， 最后一个入参是lambda表达式的时候，一般写到外面，比较好看
        for (i in 0 until length) {
            arr[i] = number % 10
            number /= 10
        }

        number = 0

        //累加到剩最高位不加，判断溢出
        for (i in 0 until length-1) {
            number = number * 10 + arr[i]
        }

        if((Int.MAX_VALUE - arr[0]) / 10 >= number ){
            return if(isNegative) -(number * 10 + arr[length-1]) else number * 10 + arr[length-1]
        }

        return 0
    }
}