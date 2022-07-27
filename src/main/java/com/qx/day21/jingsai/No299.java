package com.qx.day21.jingsai;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author xuan
 * @date 2022/6/27 12:24
 */
public class No299 {

    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i==j||i+j==n-1){
                    if(grid[i][j]==0){
                        return false;
                    }
                }else {
                    if(grid[i][j]!=0){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public int countHousePlacements(int n) {
        int mod = 1000000007;
        long[][] dp = new long[n][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        for (int i = 1; i < n; i++) {
            dp[i][0] = (dp[i-1][1]+dp[i-1][0])%mod;
            dp[i][1] = dp[i-1][0];
        }
        long a = (dp[n-1][0]+dp[n-1][1])%mod;
        return (int)(((a*a)%mod));
    }


}

