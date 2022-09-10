package com.qx.shuati.leetcode;

import java.util.Stack;

/**
 * @author xuan
 * @date 2022/8/19 21:22
 */
public class No84 {

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2,1,2}));
    }

    public static int largestRectangleArea(int[] heights) {
        int ans = 0;
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < n; i++) {
            while (stack.peek()!=-1&&heights[i]<heights[stack.peek()]){
                int pop = stack.pop();
                int start = stack.peek();
                ans = Math.max(ans,(i-start-1)*heights[pop]);
            }
            stack.push(i);
        }

        while(stack.size()>1){
            int pop = stack.pop();
            int start = stack.peek();
            ans = Math.max(ans,(n-start-1)*heights[pop]);
        }
        return ans;
    }
}
