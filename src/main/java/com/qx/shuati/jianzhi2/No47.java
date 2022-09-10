package com.qx.shuati.jianzhi2;

/**
 * @author xuan
 * @date 2022/7/4 19:11
 */
public class No47 {

    public int maxValue(int[][] grid) {
        int m = grid.length,n = grid[0].length;
        int[][] temp = new int[m+1][n+1];

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                temp[i][j] = Math.max(temp[i][j-1],temp[i-1][j]+grid[i-1][j-1]);
            }
        }
        return temp[m][n];
    }
}
