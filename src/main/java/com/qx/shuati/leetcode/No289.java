package com.qx.shuati.leetcode;

import com.qx.shuati.tool.Util;

/**
 * @author Xuan
 * Date: 2021/11/22
 * Time: 12:25
 */
public class No289 {
    public static void main(String[] args) {

        Solution solution= new Solution();
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        solution.gameOfLife(board);
        Util.print2Array(board);
    }

    static class Solution {

        public void gameOfLife(int[][] board) {
            int[][] clone = new int[board.length][board[0].length];
            for (int i = 0; i < board.length; i++) {
                clone[i] = board[i].clone();
            }
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    board[i][j] = judge(i, j, clone);
                }
            }
        }

        public int judge(int i, int j, int[][] clone) {
            int sum = 0;
            for (int k = -1; k < 2; k++) {
                for (int l = -1; l < 2; l++) {
                    if (!((k == 0 && l == 0) || i + k < 0 || i + k >= clone.length || j + l < 0 || j + l >= clone[0].length)){
                        if(clone[i+k][j+l]==1){
                            sum++;
                        }
                    }
                }
            }

            if (clone[i][j] == 1) {
                if (sum < 2) {
                    return 0;
                } else if (sum < 4) {
                    return 1;
                } else {
                    return 0;
                }
            } else {
                if (sum == 3) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    }
}
