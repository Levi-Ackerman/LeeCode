class Solution45_0 {

    /**
     * 备忘录，记录重叠子问题值
     */
    lateinit var mono: IntArray
    lateinit var nums: IntArray

    companion object {
        val CANNOT_ARRIVE = Int.MAX_VALUE //用最大值表示不可达，以便在最小值筛选的时候去掉不可达的情况
    }

    fun jump(nums: IntArray): Int {
        if (nums.size <= 1) {
            return 0
        }
        mono = IntArray(nums.size) { 0 }
        this.nums = nums
        return minStep(0)
    }

    private fun minStep(start: Int): Int {
        if (mono[start] > 0) {
            return mono[start]
        }

        var min = CANNOT_ARRIVE
        if (start + nums[start] >= nums.size - 1) {
            //从这个元素可以一步走到结尾元素，可以提前结束递归了
            min = 1
        } else if (start == nums.size - 1) {
            //已经到倒数第一个了，递归结束
            min = 0
        } else {
            //往后跳一步，最多有nums[start]种跳法，要去掉越界的情况
            for (i in start + 1..start + nums[start]) {
                if (i >= nums.size) {
                    //越界了，后面的都会越界，直接break
                    break
                }

                if (nums[i] == 0) {
                    //数组值为0是无法往前跳的，遇到0可以剪枝
                    continue
                }

                //后面走到终点的最小步数
                val steps = minStep(i)
                min = if (min < steps) min else steps
            }
            if (min != CANNOT_ARRIVE) {
                //后面的最小步数+本次走的一步，就是到终点的步数
                ++min
            }
        }
        //备忘
        mono[start] = min
        return min
    }
}