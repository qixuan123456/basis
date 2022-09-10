package com.qx.shuati.leetcode;

public class No55 {
    public static void main(String[] args) {
        int[] nums = {3,2,1,1,4};
        System.out.println(canJump(nums));
    }
    public static boolean canJump(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
           if(i<=max){
               max = Math.max(max,i+nums[i]);
           }
        }
        return max>= nums.length-1;
    }
}
