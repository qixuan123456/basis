package com.qx.day21.leetcode;

public class No63 {
    public static void main(String[] args) {
        int[][] ob = {
                {1},
                {0},
                {0}};
        System.out.println(uniquePathsWithObstacles(ob));
    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0]==1){
            return 0;
        }
        int x = obstacleGrid.length;
        int y =obstacleGrid[0].length;
        boolean xflag = false;
        boolean yflag = false;
        int[][] a = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if(i==0){
                    if(obstacleGrid[i][j]==1||xflag){
                        a[i][j] = 0;
                        xflag = true;
                    } else {
                        a[i][j] = 1;
                    }
                } else if(j==0){
                    if(obstacleGrid[i][j]==1||yflag){
                        a[i][j] = 0;
                        yflag = true;
                    }else {
                        a[i][j] = 1;
                    }
                } else {
                    if(obstacleGrid[i][j]==1){
                        a[i][j] = 0;
                    }else{
                        a[i][j] = a[i-1][j]+a[i][j-1];
                    }
                }
            }
        }
        return a[x-1][y-1];
    }
}
