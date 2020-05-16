class Solution1438_0 {
    /**
     * 找绝对差小于limit的最长子数组
     */
    fun longestSubarray(nums: IntArray, limit: Int): Int {
        if (limit < 0 || nums.isEmpty()) {
            return 0
        }
        /**
         * 当前数组，从下标head到tail，左闭右开区间
         */
        var head = 0
        var tail = 1

        //当前找到的最长满足条件的子数组
        var maxLen = 1

        //当前子数组内最小值下标
        var curMinValueIndex = 0
        //当前子数组内最大值下标
        var curMaxValueIndex = 0

        while (tail < nums.size) {
            when {
                nums[tail] > nums[curMaxValueIndex]->{
                    curMaxValueIndex = tail
                    if (nums[curMaxValueIndex] - nums[curMinValueIndex] <= limit){
                        ++ tail
                    }else{
                        
                    }
                }
                nums[tail] == nums[curMaxValueIndex] -> {
                    ++curMaxValueIndex
                    ++tail
                }
                nums[tail] < nums[curMaxValueIndex] && nums[tail] > nums[curMinValueIndex] -> {
                    ++tail
                }
                nums[tail] == nums[curMinValueIndex] -> {
                    curMinValueIndex = tail
                    ++tail
                }
                nums[tail] < nums[curMinValueIndex]->{

                }
            }
            if (nums[tail] < nums[curMaxValueIndex]){}
            var min = Int.MAX_VALUE
            var max = Int.MIN_VALUE
            for (i in head..tail) {
                min = kotlin.math.min(nums[i], min)
                max = kotlin.math.max(nums[i], max)
            }
            if (max - min <= limit) {
                //tail的加入没有导致越界
                maxLen = kotlin.math.max(maxLen, tail - head + 1)
                ++tail
            } else {
                ++head
            }
        }
        return maxLen
    }
}