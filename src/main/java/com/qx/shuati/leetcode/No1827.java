package com.qx.shuati.leetcode;

public class No1827 {
    public static void main(String[] args) {
        int[] nums = {1, 5, 2, 4, 1};
        System.out.println(minOperations(nums));
    }
    public static int minOperations(int[] nums) {
        if(nums==null||nums.length<2){
            return 0;
        }
        int sum=0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]<nums[i-1]){
                sum+=(nums[i-1]-nums[i]+1);
                nums[i] = nums[i-1]+1;
            }
        }
        return sum;
    }
}
