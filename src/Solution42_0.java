class Solution42_0 {
    //接雨水，双柱蓄水
    public int trap(int[] height) {
        int[] stack = new int[height.length];
        int index = -1;
        int result = 0;
        for (int h : height) {
            if (index == -1) {
                //栈空，入栈
                stack[++index] = h;
            } else if (index == 0) {
                //栈一个元素，新元素大于等于旧元素，替换旧元素，否则，入栈
                if (h >= stack[index]) {
                    stack[index] = h;
                } else {
                    stack[++index] = h;
                }
            } else {
                //栈里多于一个元素时
                if (h >= stack[0]) {
                    //新元素不低于最左元素，蓄水成功，蓄水上限是最左柱子的高度
                    while (index > 0) {
                        result += stack[0] - stack[index];
                        --index;
                    }
                    //新柱子到最左边来蓄水
                    stack[index] = h;
                } else {
                    stack[++index] = h;
                }
            }

        }
        //循环结束，一根或两根柱子无法蓄水，所以不考虑
        if (index > 1) {
            int max = stack[index];
            while (--index > 0) {
                //从右遍历到左
                if (stack[index] >= max) {
                    //高位，取代
                    max = stack[index];
                } else {
                    //低位，蓄水
                    result += max - stack[index];
                }
            }
        }
        return result;
    }
}
