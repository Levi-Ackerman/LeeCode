class Solution69_0 {
    //69 求x的开方，保留整数部分
    fun mySqrt(x: Int): Int {
        val xLong = x.toLong()

        var i:Long = 0
        var j:Long = xLong
        //二分查找
        while (i != j) {
            val media = (i + j) / 2
            val square = media * media
            val nextSquare = (media+1)*(media + 1)
            when{
                xLong in square..(nextSquare - 1)-> return media.toInt()
                nextSquare == xLong -> return media.toInt() +1
                nextSquare < xLong -> i = media +1
                square > xLong -> j = media - 1
            }


//            println("i:$i,j:$j")
        }

        return i.toInt()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(Solution69_0().mySqrt(6))
        }
    }
}