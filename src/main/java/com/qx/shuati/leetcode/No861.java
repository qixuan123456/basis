package com.qx.shuati.leetcode;

/**
 * User: xuan
 * Date: 2021/10/26
 * Time: 18:56
 */
public class No861 {
    public static void main(String[] args) {
        int[][] grid = {{0,0,1,1},{1,0,1,0},{1,1,0,0}};
        No861 no861 = new No861();
        System.out.println(no861.matrixScore(grid));
    }

    public int matrixScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int res = m*(1<< (n-1));

        for (int i = 1; i < n; i++) {
            int a = 0;
            for (int j = 0; j < m; j++) {
                if(grid[j][0]==1){
                    a+=grid[j][i];
                }else {
                    a+=1-grid[j][i];
                }
            }
            res+= (1<<(n-i-1))*(Math.max(a,m-a));
        }
        return res;
    }
}
