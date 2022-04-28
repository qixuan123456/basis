package com.qx.day21.leetcode;

public class No70 {
    public static void main(String[] args) {
        System.out.println(climbStairs(40));
    }
    public static int climbStairs(int n) {
        if(n<3){
            return n;
        }
        int prep = 1;
        int pre = 2;
        int current = 0;
        for (int i = 3; i < n+1; i++) {
            current = prep + pre;
            prep = pre;
            pre = current;
        }
        return current;
    }

}
