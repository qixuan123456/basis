package day21.jingsai.no247;

import day21.tool.Util;

public class No2 {
    public static void main(String[] args) {
        int[][] grid = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int k = 2;
        Util.print2Array(rotateGrid(grid,k));
    }
    public static int[][] rotateGrid(int[][] grid, int k) {
        while(k>0){
            rotate1(grid);
            k--;
        }
        return grid;
    }

    public static void rotate1(int[][] grid){
        int x = grid.length ;
        int y = grid[0].length;
        for (int i = 0; i < Math.min(x,y)/2; i++) {
            rotateX(grid,i);
        }
    }
    public static void rotateX(int[][] grid,int z){
        int x = grid.length ;
        int y = grid[0].length;
        int k;
        k = grid[z][z];
        for (int i = z; i < y-z-1; i++) {
            grid[z][i] = grid[z][i+1];
        }
        for (int i = z; i < x-z-1; i++) {
            grid[i][y-z-1] = grid[i+1][y-z-1];
        }
        for (int i = y-z-1; i > z; i--) {
            grid[x-z-1][i] = grid[x-z-1][i-1];
        }
        for (int i = x-z-1; i > z; i--) {
            grid[i][z] = grid[i-1][z];
        }
        grid[z+1][z] = k;
    }
}















