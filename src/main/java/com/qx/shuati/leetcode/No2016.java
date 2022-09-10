package com.qx.shuati.leetcode;

/**
 * User: xuan
 * Date: 2021/9/27
 * Time: 12:28
 */
public class No2016 {
    public static void main(String[] args) {
        int[] nums = {1,5,2,10};
        System.out.println(maximumDifference(nums));
    }
    public static int maximumDifference(int[] nums) {
        int max = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]<nums[j]){
                    max = Math.max(max,nums[j]-nums[i]);
                }
            }
        }
        return max;
    }
}
