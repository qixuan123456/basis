package com.qx.day21.leetcode;

/**
 * User: xuan
 * Date: 2021/9/27
 * Time: 12:55
 */
public class No2017 {

    public static void main(String[] args) {

        int[][] grid = {
                {1,3,1,15},
                {1,3,3,1}};
        System.out.println(gridGame(grid));
    }

    public static long gridGame(int[][] grid) {
        long res = Long.MAX_VALUE;
        for (int i = 0; i < grid[0].length; i++) {
            long a = 0L;
            long b = 0L;
            int flag = 0;
            for (int j = 0; j < grid[0].length; j++) {
                if(i==j){
                    flag = 1;
                    continue;
                }
                if(flag==0){
                    a +=grid[1-flag][j];
                }else {
                    b +=grid[1-flag][j];
                }

            }
            res = Math.min(res,Math.max(a,b));
        }
        return res;
    }



}
