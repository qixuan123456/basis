package com.qx.shuati.jianzhi2;

/**
 * @author xuan
 * @date 2022/8/20 10:36
 */
public class No8 {

    public int minSubArrayLen(int target, int[] nums) {

        int current = nums[0];
        int l = 0, r = 0;

        int ans = Integer.MAX_VALUE;
        while (l <= r && r < nums.length) {
            if (current >= target) {
                ans = Math.min(ans, r - l + 1);
                current -= nums[l];
                l--;
            } else {
                r++;
                if (r < nums.length) {
                    current += nums[r];
                }
            }
        }

        return ans;
    }
}
