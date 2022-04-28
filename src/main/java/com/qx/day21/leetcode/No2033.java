package com.qx.day21.leetcode;

/**
 * User: xuan
 * Date: 2021/10/12
 * Time: 19:10  不会
 */
public class No2033 {
    public static void main(String[] args) {
        No2033 no2033 = new No2033();
        int[][] grip = {{2, 4},
                        {6, 8}};
        int x = 2;
        System.out.println(no2033.minOperations(grip, x));
    }

    public int minOperations(int[][] grid, int x) {
        int sum = 0, aver = 0, h = grid.length, l = grid[0].length;
        int res = 0;
        for (int[] ints : grid) {
            for (int j = 0; j < l; j++) {
                sum += ints[j];
            }
        }
        if(sum%(h*l)!=0){
            return -1;
        }
        aver = sum /(h*l);
        for (int[] ints : grid) {
            for (int j = 0; j < l; j++) {
                if (Math.abs(ints[j] - aver) % x != 0) {
                    return -1;
                }
                res += Math.abs(ints[j] - aver) / x;
            }
        }
        return res;
    }
}
