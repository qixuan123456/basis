package day21.leetcode;

import day21.tool.Util;

import java.util.Arrays;

/**
 * @author Xuan
 * Date: 2021/12/7
 * Time: 15:48
 */
public class No1034 {

    public static void main(String[] args) {
        int[][] grip = {{1,1,1},
                {1,1,1},
                {1,1,1}};
        No1034 no1034 = new No1034();
        Util.print2Array(no1034.colorBorder(grip, 1, 1, 2));
        //System.out.println(Arrays.toString(no1034.colorBorder(grip, 1, 1, 3)));
    }

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int maxRow = grid.length;
        int maxCol = grid[0].length;
        int[][] res = new int[maxRow][maxCol];
        for (int i = 0; i < maxRow; i++) {
            res[i] = grid[i].clone();
        }
        dfs(res,grid,row,col,color,grid[row][col]);
        return res;
    }
    public void dfs(int[][] res,int[][] grid, int row, int col, int color,int curColor){
        if(row<0||col<0||row> res.length-1||col>res[0].length-1||grid[row][col]!=curColor){
            return;
        }

        if(row==0||col==0||row == res.length-1||col ==res[0].length-1
                ||((grid[row+1][col]!=curColor&&grid[row+1][col]!=0)
                ||(grid[row-1][col]!=curColor&&grid[row-1][col]!=0)
                ||(grid[row][col+1]!=curColor&&grid[row][col+1]!=0)
                ||(grid[row][col-1]!=curColor&&grid[row][col-1]!=0))){
            res[row][col] = color;
        }

        grid[row][col] =0;
        dfs(res,grid,row-1,col,color,curColor);
        dfs(res,grid,row+1,col,color,curColor);
        dfs(res,grid,row,col-1,color,curColor);
        dfs(res,grid,row,col+1,color,curColor);
    }
}
