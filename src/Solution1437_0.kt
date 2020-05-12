class Solution1437_0 {
    /**
     * 至少返回k个元素
     */
    fun kLengthApart(nums: IntArray, k: Int): Boolean {
        var lastIndex = -1
        for (i in 0 until nums.size) {
            if (nums[i] == 1) {
                lastIndex = if (lastIndex == -1) {
                    i
                }else{
                    if (i - lastIndex < k+1){
                        return false
                    }else{
                        i
                    }
                }
            }
        }
        return true
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(Solution1437_0().kLengthApart(intArrayOf(1,0,0,1,0,0,1),2))
        }
    }
}