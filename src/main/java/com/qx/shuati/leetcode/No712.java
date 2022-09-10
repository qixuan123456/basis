package com.qx.shuati.leetcode;

/**
 * @author xuan
 * @date 2022/6/22 15:28
 */
public class No712 {

    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i-1][0]+s1.charAt(i);
        }
        for (int i = 1; i <= m; i++) {
            dp[0][i] = dp[0][i-1]+s2.charAt(i);
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if(s1.charAt(i)==s2.charAt(j)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(dp[i][j-1]+s2.charAt(j),dp[i-1][j]+s1.charAt(i));
                }
            }
        }
        System.out.println(dp[n][m]);
        return dp[n][m];
    }
}
