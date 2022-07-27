package com.qx.day21.leetcode;

import java.util.Arrays;

/**
 * @author xuan
 * @date 2022/7/10 16:31
 */
public class No741 {

    public static void main(String[] args) {
        System.out.println(new No741().cherryPickup(new int[][]{{1, -1,-1,-1 ,-1}, {1, 0,1,-1, -1}, {0,-1, 1,0, 1},{1,0,1,1,0},{-1,-1,-1,1,1}}));
    }

    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][] dp = new int[2*n][n][n];
        if(grid[0][0] == -1){
            return 0;
        }
        for (int i = 0; i < 2*n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j],-1);
            }
        }
        dp[0][0][0] = grid[0][0];
        for (int i = 1; i < 2 * n-1; i++) {
            for (int j = 0; j <= i&&j<n; j++) {
                for (int k = j; k <= i&&k<n; k++) {
                    if(i-j>=n||i-k>=n){
                        continue;
                    }
                    dp[i][j][k] = -1;
                    if(grid[j][i-j]==-1||grid[k][i-k]==-1){
                        continue;
                    }
                    int res = grid[j][i-j];
                    if(j!=k){
                        res += grid[k][i-k];
                    }
                    if(j>0&&k>0){
                        dp[i][j][k] = Math.max(dp[i][j][k],dp[i-1][j-1][k-1]==-1?-1:dp[i-1][j-1][k-1]+res);
                    }
                    if(j>0){
                        dp[i][j][k] = Math.max(dp[i][j][k],dp[i-1][j-1][k]==-1?-1:dp[i-1][j-1][k]+res);
                    }
                    if(k>0){
                        dp[i][j][k] = Math.max(dp[i][j][k],dp[i-1][j][k-1]==-1?-1:dp[i-1][j][k-1]+res);
                    }

                    dp[i][j][k] = Math.max(dp[i][j][k],dp[i-1][j][k]==-1?-1:dp[i-1][j][k]+res);
                }
            }
        }
        return Math.max(0,dp[2*n-2][n-1][n-1]);
    }


}
