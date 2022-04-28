package com.qx.day21.leetcode;

public class No413 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5, 3, 2};
        System.out.println(numberOfArithmeticSlices(nums));
    }

    public static int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3)
            return 0;
        int sum = 0;
        int start = 0;
        int len = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                len = i - start + 1;
                if (i == nums.length - 1 && len >= 2) {
                    sum += (len - 1) * (len - 2) / 2;
                }
            } else if (len >= 2) {
                sum += (len - 1) * (len - 2) / 2;
                start = i - 1;
                len = 2;
            }

        }
        return sum;
    }


}
