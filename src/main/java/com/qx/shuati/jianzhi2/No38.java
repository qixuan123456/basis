package com.qx.shuati.jianzhi2;

import java.util.Stack;

/**
 * @author xuan
 * @date 2022/8/20 14:42
 */
public class No38 {

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty()&&temperatures[i]>temperatures[stack.peek()]){
                int pop = stack.pop();
                res[pop] = i-pop;
            }
            stack.push(i);
        }
        return res;
    }
}
