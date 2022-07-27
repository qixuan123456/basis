package com.qx.day21.leetcode;

/**
 * @author xuan
 * @date 2022/6/23 13:55
 */
public class No1143 {
    public static void main(String[] args) {

    }

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(),m = text2.length();
        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                char c1 = text1.charAt(i);
                char c2 = text2.charAt(j);
                if(c1==c2){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }

            }
        }
        return dp[n][m];
    }
}
