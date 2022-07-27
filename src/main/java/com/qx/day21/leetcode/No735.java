package com.qx.day21.leetcode;

import java.util.Stack;

/**
 * @author xuan
 * @date 2022/7/13 14:13
 */
public class No735 {
    public static void main(String[] args) {

    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {

            while(true){
                if(stack.isEmpty()){
                    stack.push(asteroids[i]);
                    break;
                }
                int peek = stack.peek();
                if(peek*asteroids[i]>0||(peek<0&&asteroids[i]>0)){
                    stack.push(asteroids[i]);
                    break;
                }else {
                    if(Math.abs(peek)>Math.abs(asteroids[i])){
                        break;
                    }else if(Math.abs(peek)<Math.abs(asteroids[i])){
                        stack.pop();
                    }else {
                        stack.pop();
                        break;
                    }
                }
            }
        }
        int[] ans = new int[stack.size()];
        for (int i = ans.length-1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }
}
