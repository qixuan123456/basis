package com.qx.shuati.leetcode;

import java.util.Arrays;

/**
 * User: xuan
 * Date: 2021/9/25
 * Time: 12:12
 */
public class No2012 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(sumOfBeauties(nums));
    }

    public static int sumOfBeauties(int[] nums) {
        int res = 0;
        int[] left = Arrays.copyOf(nums, nums.length);
        int[] right = Arrays.copyOf(nums, nums.length);
        for (int i = 1; i < nums.length; i++) {
            left[i] = Math.max(left[i], left[i - 1]);
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = Math.min(right[i], right[i + 1]);
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > left[i - 1] && nums[i] < right[i + 1]) {
                res += 2;
            } else if (nums[i] > nums[i - 1] && nums[i] < nums[i + 1]) {
                res += 1;
            }
        }
        return res;
    }
}
