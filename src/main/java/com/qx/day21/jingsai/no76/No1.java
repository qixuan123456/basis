package com.qx.day21.jingsai.no76;

/**
 * @author xuan
 * @date 2022/4/21 19:38
 */
public class No1 {

    public static void main(String[] args) {

    }
    public static int findClosestNumber(int[] nums) {
        int ans = Integer.MAX_VALUE;
        for (int num : nums) {
            if (Math.abs(num) < Math.abs(ans)) {
                ans = num;
            } else if (Math.abs(num) == Math.abs(ans)) {
                ans = Math.max(ans, num);
            }
        }
        return ans;
    }
}
