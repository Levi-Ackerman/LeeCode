class Solution4_0{
    //找两个有序数组的中位数，要求时间复杂度 log(m+n)
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        //中位数，对于排序数组m长度，是第（m+1）/2个数（奇数长度），或者m/2(也会是(m+1)/2)和m/2+1的平均值
        //所以，重点先求第 k=(m+1)/2个数，也就是第k小的数，那么，要在两个数组中，砍掉较小的(k-1)个数
        //题目要去log(m+n)的时间，那就是二分法没错了
        val k = (nums1.size + nums2.size + 1) /2

        return 0.0
    }
}