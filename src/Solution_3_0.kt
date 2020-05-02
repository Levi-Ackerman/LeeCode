import java.lang.Integer.max

class Solution_3_0 {
    fun lengthOfLongestSubstring(s: String): Int {
        if (s.isEmpty()){
            return 0
        }
        //起始下标
        var head = 0
        //当前长度
        var len = 1
        //历史最大长度
        var max = 1

        for (i in 1 until s.length) {
            val end = head + len
            val start = head
            for (j in start until end) {
                if (s[i] == s[j]){
                    //有重复，head右移到j的下一位，将重复的字符和左边的所有字符都移出去
                    head = j+1
                    len = end - head
                }
            }
            //入栈了i元素，所以长度+1
            ++len
            //更新最大值
            max = max(len, max)
        }

        return max
    }
}