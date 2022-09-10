package com.qx.shuati.leetcode;

/**
 * @author xuan
 * @date 2022/6/23 12:57
 */
public class No85 {


    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length,m = matrix[0].length;
        int[][] dp = new int[n][m];
        int ans = 0;


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(matrix[i][j]=='1'){
                    if(j==0){
                        dp[i][j] = 1;
                    }else {
                        dp[i][j] = dp[i][j-1]+1;
                    }
                    int min = dp[i][j];
                    int cow = 0;
                    for (int k = i; k >= 0; k--) {
                        if(matrix[k][j]=='1'){
                            min = Math.min(min,dp[k][j]);
                            cow++;
                            ans = Math.max(cow*min,ans);
                        }else {
                            break;
                        }
                    }
                }else {
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }
}
