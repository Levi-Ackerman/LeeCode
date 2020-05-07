import kotlin.math.cos
import kotlin.math.min

class Solution983_1 {

    /**
     * 备忘从mDays的某个下标开始旅行到结束需要花费的最小费用
     */
    private lateinit var mMemo: IntArray

    private lateinit var mCosts: IntArray

    private lateinit var mDays: IntArray

    /**
     * 最后一天
     */
    private var mLastDay: Int = 0

    /**
     * 当前mDays遍历到的下标
     */
    private var mDayIndex = 0

    /**
     * 旅行最低票价
     */
    fun mincostTickets(days: IntArray, costs: IntArray): Int {
        if (days.isEmpty()) {
            return 0
        }

        if (days.size == 1) {
            return costs[1]
        }

        mDays = days
        mCosts = costs

        //日子从1开始算起，所以多给备忘录一个元素吧，空出0号下标来
        mMemo = IntArray(days[days.size-1] + 1) { 0 }

        mLastDay = mDays[mDays.size - 1]

        return minCost(1, -1)
    }

    /**
     * 从第[startDay]天开始到结束旅行的日子，花费的最小票钱
     * @param lastDayIndex 已经旅行过的日子的最大下标
     */
    private fun minCost(startDay: Int, lastDayIndex: Int): Int {
        if (startDay > mLastDay) {
            //旅行结束
            return 0
        }

        //下一个需要旅行的日子
        val travelDay = mDays[lastDayIndex + 1]
        if (mMemo[travelDay] == 0) {
            val cost1 = mCosts[0] + minCost(travelDay + 1, lastDayIndex + 1)
            val cost7 = mCosts[1] + minCost(travelDay + 7, lastDayIndex + 1)
            val cost30 = mCosts[2] + minCost(travelDay + 30, lastDayIndex + 1)

            val min = min(cost1, min(cost7, cost30))

            mMemo[travelDay] = min
        }

        return mMemo[travelDay]
    }

    fun test() {
        System.out.println(mincostTickets(intArrayOf(1, 4, 6, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 20, 21, 22, 23, 27, 28),
                intArrayOf(3, 13, 45)))
    }
}