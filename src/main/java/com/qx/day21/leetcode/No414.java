package com.qx.day21.leetcode;

import java.util.Arrays;

/**
 * User: xuan
 * Date: 2021/10/6
 * Time: 18:26
 */
public class No414 {
    public static void main(String[] args) {

        int[] nums = {3,2};
        System.out.println(thirdMax(nums));
    }
    public static int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int y = 1;
        for (int i = nums.length-2; i >= 0; i--) {
            if(nums[i]!=nums[i+1]){
                y++;
                if(y==3){
                    return nums[i];
                }
            }
        }
        return nums[nums.length-1];
    }
}
