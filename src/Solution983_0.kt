import kotlin.math.min

class Solution983_0 {
    /**
     * 所有需要旅行的日子
     */
    private lateinit var mDays: IntArray
    /**
     * 3种套票的售价
     */
    private lateinit var mCosts: IntArray
    /**
     * 3中套票的有效期
     */
    private val mExpiration = intArrayOf(1, 7, 30)

    /**
     * 备忘从mDays的某个下标开始旅行到结束需要花费的最小费用
     */
    private lateinit var mMemo: IntArray

    /**
     * 旅行最低票价
     */
    fun mincostTickets(days: IntArray, costs: IntArray): Int {
        mDays = days
        mCosts = costs
        mMemo = IntArray(mDays.size) { 0 }
        return minCost(0, -1)
    }

    /**
     * 子问题，每次旅行最低票价迭代
     * @param expirationDay 上次旅行买票后，在[expirationDay]这天之前都不需要买票
     * @param lastIndex 上次旅行是mDays[lastIndex]这一天买的票
     */
    private fun minCost(expirationDay: Int, lastIndex: Int): Int {

        var startIndex = lastIndex + 1
        while (startIndex < mDays.size) {
            if (mDays[startIndex] > expirationDay) {
                break
            }
            ++startIndex
        }

        if (startIndex == mDays.size) {
            //遍历到mDays的界外了也没有break，此时旅行结束
            return 0
        }

        //从startIndex开始往后面旅行

        //如果有备忘，就用备忘记录
        if (mMemo[startIndex] > 0) {
            return mMemo[startIndex]
        }

        //从startIndex开始往后面旅行，有三种方案
        var cost = Int.MAX_VALUE
        var minIndex = Int.MAX_VALUE
        for (i in 0 until mCosts.size) {
            val curCost = mCosts[i] + minCost(expirationDay + mExpiration[i], startIndex)
            if (curCost <= cost){
                minIndex = i
                cost = curCost
            }
        }

        println("第${mDays[startIndex]} 天买票，花费${mCosts[minIndex]}元，有效期${mExpiration[minIndex]}天")

        mMemo[startIndex] = cost
        return cost
    }

    fun test(){
        mincostTickets(intArrayOf(1,4,6,9,10,11,12,13,14,15,16,17,18,20,21,22,23,27,28),
                intArrayOf(3,13,45))
    }
}