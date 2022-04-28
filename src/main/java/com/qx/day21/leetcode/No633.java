package com.qx.day21.leetcode;

public class No633 {
    public static void main(String[] args) {
        Solution s=new Solution();

        System.out.println(s.judgeSquareSum(10));
    }
}
class Solution {
    public boolean judgeSquareSum(int c) {
        for(int i=0;i<Math.sqrt(c);i++){
            double a=c-i*i;
            double n;
            a=Math.sqrt(a);
            n=(int)a;
            if(a==n)
                return true;
        }
        return false;
    }
}