package com.qx.day21.leetcode;

public class No1800 {
    public static void main(String[] args) {
        int[] nums = {10,20,30,5,10,50};
        System.out.println(maxAscendingSum(nums));
    }
    public static int maxAscendingSum(int[] nums) {
        int max=nums[0];
        int sum =nums[0];
        for (int i = 1; i <nums.length; i++) {
            if(nums[i]<nums[i-1]){
                sum=nums[i];
            }
            else {
                sum += nums[i];
                if(max<sum)
                max = sum;
            }
        }
        return max;
    }
}
