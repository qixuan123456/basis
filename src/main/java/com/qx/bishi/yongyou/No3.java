package com.qx.bishi.yongyou;

import java.util.Stack;

/**
 * @author xuan
 * @date 2022/9/9 20:19
 */
public class No3 {

    public int[] findBuilding (int[] heights) {
        // write code here
        int n = heights.length;
        int[] ans = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> leftstack = new Stack<>();
        Stack<Integer> rightstack = new Stack<>();
        for (int i = n-1; i >=0; i--) {
            right[i] = rightstack.size();
            if(i==n-1){
                rightstack.push(heights[i]);
            }else if(heights[i]<rightstack.peek()){
                rightstack.push(heights[i]);
            }else {
                while (!rightstack.isEmpty()&&heights[i]>=rightstack.peek()){
                    rightstack.pop();
                }
                rightstack.push(heights[i]);
            }
        }
        for (int i = 0; i < n; i++) {
            left[i] = leftstack.size();
            if(i==0){
                leftstack.push(heights[i]);
            }else if(heights[i]<leftstack.peek()){
                leftstack.push(heights[i]);
            }else {
                while (!leftstack.isEmpty()&&heights[i]>=leftstack.peek()){
                    leftstack.pop();
                }
                leftstack.push(heights[i]);
            }
        }
        for (int i = 0; i < n; i++) {
            ans[i] = left[i]+right[i]+1;
        }
        return ans;
    }
}
