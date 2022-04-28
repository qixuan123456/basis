package com.qx.day21.leetcode;

public class No209 {
    public static void main(String[] args) {
        int target = 100;
        int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(target,nums));
    }
    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int minlength = 0;
        int sum = 0;
        while (left<nums.length&&right<nums.length){
            sum += nums[right];
            if(sum>=target){
                if(minlength==0){
                    minlength=right-left+1;
                }
                else {
                    minlength = Math.min(minlength,right-left+1);
                }
                sum-=nums[left];
                sum-=nums[right];
                left++;
            }
            else{
                right++;
            }
        }
        return minlength;
    }
}
