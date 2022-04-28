package com.qx.shuati.niuke.alibaba2021;

/**
 * @author Xuan
 * Date: 2022/4/14
 * Time: 15:52
 */
public class No3 {
    public static void main(String[] args) {
        dfs(2);
        dfs(4,3);
    }

    public static void dfs(int n){
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] +=dp[j]*dp[i-1-j];
            }
        }
        System.out.println(dp[n]);
    }

    public static void dfs(int n,int m){
        long[][] dp = new long[n+1][m+1];
        for (int i = 0; i < m + 1; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j<m+1; j++) {
                if(j<=i){
                    for (int k = 0; k <i; k++) {
                        dp[i][j] = (dp[i][j] + (dp[k][j - 1] * dp[i - 1 - k][j - 1]) % 1000000007) % 1000000007;
                    }
                }else {
                    dp[i][j] = dp[i][i];
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}
