class Solution221_0 {
    /**
     * 0，1矩阵中，找全为1的最大正方形面积
     * @param matrix "0","1" 二维字符矩阵
     */
    fun maximalSquare(matrix: Array<CharArray>): Int {
        val height = matrix.size
        if(height == 0){
            return 0
        }
        val width = matrix[0].size
        if(width == 0){
            return 0
        }

        return 0
    }

    fun test() {
        arrayOf(arrayOf("1", "0", "1", "0", "0"), arrayOf("1", "0", "1", "1", "1"), arrayOf("1", "1", "1", "1", "1"), arrayOf("1", "0", "0", "1", "0"))
    }
}