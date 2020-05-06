class Solution5_0 {
    companion object {
        const val MAX_LENGTH = 1000
    }

    /**
     * 当前最长回文的长度
     */
    var mCurMaxLen = 1
    /**
     * 当前最长回文的起点下标
     */
    var mCurStart = 0

    /**
     * 最长回文字符串，可以假设输入最长为1000
     * 暴力法：直接每个数字下标往两边扫描，看是否对称
     * 回文有两种情况，奇数回文（正中央单个字符）和偶数回文（完全对称，不会有单个字符）
     */
    fun longestPalindrome(s: String): String {
        for (i in 1..s.length) {
            //考虑偶数回文
            val hasEven = i+1 < s.length && s[i] == s[i+1]

            for (distance in 0..i) {
                if (i + distance >= s.length) {
                    //出界，不用判断了
                    break
                }
                if (s[i + distance] == s[i - distance]){
                    //对称，继续走
                }
            }
        }
        return ""
    }
}