import kotlin.math.max
import kotlin.math.min

class Solution356_0 {
    /**
     * 数组内所有点，是否能关于某条y轴的平行线找到对称点，要求复杂度优于On平方
     */
    fun isReflected(points: Array<IntArray>): Boolean {
        if (points.isEmpty()) {
            return true
        }
        //找中间点，如果所有点对称，那么不在对称线的所有点的y值一定都相等，且x值的最小值和最大值一定是一对对称点
        //每一对对称点的x值相加都会是同一个值，即最小值和最大值之和

        var minX = Int.MAX_VALUE
        var maxX = Int.MIN_VALUE

        val xSet = HashSet<Int>()

        for (p in points) {

            minX = min(minX, p[0])
            maxX = max(maxX, p[0])

            xSet.add(p[0])
        }
        val xSum = minX + maxX
        val mediaLine = xSum /2

        val ySet = HashSet<Int>()
        for (p in points){
            if (!xSet.contains(xSum-p[0])){
                return false
            }

            if (p[0] != mediaLine){
                ySet.add(p[1])
            }
        }

        return ySet.size <= 1
    }

    fun test(){
        //[[10,10],[11,11],[9,11]]
        print(isReflected(arrayOf(intArrayOf(1,2),intArrayOf(2,2),intArrayOf(1,4), intArrayOf(2,4))))
    }
}