class Solution45_1 {

    /**
     * 备忘录，记录重叠子问题值
     */
    lateinit var mono: IntArray

    companion object {
        const val CANNOT_ARRIVE = Int.MAX_VALUE //用最大值表示不可达，以便在最小值筛选的时候去掉不可达的情况
        const val NOT_INIT = Int.MIN_VALUE
    }

    fun jump(nums: IntArray): Int {
        if (nums.size <= 1) {
            return 0
        }
        if (nums.size == 2) {
            return 1
        }
        mono = IntArray(nums.size) {
            when {
                nums.size - 1 == it -> //倒数第一个数0步到达
                    0
                nums.size - 1 <= nums[it] + it -> //距离尾数在可达半径内标为可达
                    1
                nums[it] == 0 -> //最多走0步的元素无法到达尾数
                    CANNOT_ARRIVE
                else -> //其他数标为NOT_INIT
                    NOT_INIT
            }
        }
        for (i in nums.size - 2 downTo 0) {
            if (mono[i] != NOT_INIT) {
                //已经初始化好了备忘录的数据，忽略
                continue
            }

            //到了这里，nums[i]一定不会为0，所以可以直接让min=mono[i+1]，少一轮遍历
            var min = mono[i+1]
            for (j in i+2..i + nums[i]) {
                //找半径内最短可达尾数路径
                min = if (mono[j] < min) mono[j] else min
            }
            if(min != CANNOT_ARRIVE){
                //多的一步是从这一步往min的那一步跨的
                min += 1
            }
            mono[i] = min
        }

        return mono[0]
    }

}