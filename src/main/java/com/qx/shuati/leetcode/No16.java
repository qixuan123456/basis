package com.qx.shuati.leetcode;

import java.util.Arrays;

/**
 * @author Xuan
 * Date: 2022/3/17
 * Time: 14:57
 */
public class No16 {
    public static void main(String[] args) {
        No16 no16 = new No16();
        int[] nums = {1, 1, 1, 0};
        int target = 100;
        System.out.println(no16.threeSumClosest(nums, target));
    }


    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 2000000;

        for (int i = 0; i < nums.length; i++) {

            if (i > 0 && nums[i-1] == nums[i]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                int a = Math.abs(sum - target);
                int b = Math.abs(res - target);
                if (sum == target) {
                    return target;
                } else if (sum < target) {
                    if (a < b) {
                        res = sum;
                    }
                    l++;
                } else {
                    if (a < b) {
                        res = sum;
                    }
                    r--;
                }
            }
        }
        return res;
    }
}








