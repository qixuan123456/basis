package com.qx.shuati.leetcode;

import java.util.Arrays;

public class No1838 {
    public static void main(String[] args) {
        int[] nums = new int[100001];
        nums[100000] = 1;
        int k = 100000;
        System.out.println(maxFrequency(nums,k));
    }
    public static int maxFrequency(int[] nums, int k) {
        int max = 1;
        int left = 0;
        int right = 0;
        int length = nums.length;
        Arrays.sort(nums);
        long sum = nums[0];
        while (left<=right&&right<length-1){
            if((sum+k)/(right-left+1)>=nums[right+1]){
                right++;
                sum+=nums[right];
                max = Math.max(max,right-left+1);
            }else {
                sum-=nums[left];
                left++;
                if(right<left){
                    sum = nums[left];
                    right = left;
                }
            }
        }
        return max;
    }
}
