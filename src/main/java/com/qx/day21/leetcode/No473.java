package com.qx.day21.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author xuan
 * @date 2022/6/1 10:46
 */
public class No473 {

    public static void main(String[] args) {
        No473 no473 = new No473();
        System.out.println(no473.makesquare(new int[]{10, 6, 5, 5, 5, 3, 3, 3, 2, 2, 2, 2}));
    }

    public boolean makesquare(int[] matchsticks) {
        int totalLen = Arrays.stream(matchsticks).sum();
        if (totalLen % 4 != 0) {
            return false;
        }
        int len = totalLen / 4, n = matchsticks.length;
        int[] dp = new int[1 << n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int s = 1; s < (1 << n); s++) {
            for (int k = 0; k < n; k++) {
                if ((s & (1 << k)) == 0) {
                    continue;
                }
                int s1 = s & ~(1 << k);
                if (dp[s1] >= 0 && dp[s1] + matchsticks[k] <= len) {
                    dp[s] = (dp[s1] + matchsticks[k]) % len;
                    break;
                }
            }
        }
        return dp[(1 << n) - 1] == 0;
    }

}
