package com.qx.shuati.leetcode;

public class No200 {
    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}};
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j]=='1'){
                    sum ++;
                    findOne(grid,i,j);
                }
            }
        }
        return sum;
    }
    public static void findOne(char[][] grid,int i,int j){
        if(i<0||j<0||i>=grid.length||j>= grid[i].length||grid[i][j]=='0'){
            return;
        }
        grid[i][j] = '0';
        findOne(grid,i-1,j);
        findOne(grid,i+1,j);
        findOne(grid,i,j-1);
        findOne(grid,i,j+1);
    }
}
