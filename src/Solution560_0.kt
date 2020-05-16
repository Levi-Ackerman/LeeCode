class Solution560_0 {
    /**
     * 找和为k的连续的子数组的个数，是子数组的个数(即有多少种情况)，不是子数组元素数
     */
    fun subarraySum(nums: IntArray, k: Int): Int {
        //子数组个数计数器
        var count = 0
        //子数组元素的累计值
        var sum = 0

        var head = 0
        var tail = 0

        while (tail < nums.size){

            sum += nums[tail]

            while (sum >= k && head <=tail){
                if (sum == k){
                    count ++
                }
                sum -= nums[head]

                head ++
            }

            tail ++
        }
        return count
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
//            println(Solution560_0().subarraySum(intArrayOf(1,1,1),2))
//            println(Solution560_0().subarraySum(intArrayOf(1,1,0),0))
//            println(Solution560_0().subarraySum(intArrayOf(0,1,0),0))
            println(Solution560_0().subarraySum(intArrayOf(0,0,0),0))
        }
    }
}