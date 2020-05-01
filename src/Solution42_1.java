class Solution42_1 {
    //接雨水，备忘录扫描
    public int trap(int[] height) {
        if (height == null || height.length < 3){
            return 0;
        }
        int result = 0;
        //往右走能找到的最高柱子
        int[] maxRight = new int[height.length];
        //往左走能找到的最高柱子
        int[] maxLeft = new int[height.length];
        maxRight[height.length - 1] = 0;
        maxLeft[0] = 0;
        for (int i = 1; i < height.length - 1; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
            maxRight[height.length - i - 1] = Math.max(maxRight[height.length - i], height[height.length - i]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            int water = Math.min(maxLeft[i], maxRight[i]) - height[i];
            if (water > 0) {
                result += water;
            }
        }
        return result;
    }
}
