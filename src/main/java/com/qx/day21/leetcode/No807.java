package com.qx.day21.leetcode;

public class No807 {
    public static void main(String[] args) {
        int[][] a = {{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};
        System.out.println(maxIncreaseKeepingSkyline(a));
    }
    public static int maxIncreaseKeepingSkyline(int[][] grid) {
        int num=0;
        int[] x=new int[grid[0].length];
        int[] y=new int[grid.length];
        for(int i=0;i<grid[0].length;i++){
            int a=grid[0][i];
            for(int j=1;j<grid.length;j++){
                if(a<grid[j][i]){
                    a=grid[j][i];
                }
            }
            x[i]=a;
        }
        for(int i=0;i<grid.length;i++){
            int a=grid[i][0];
            for(int j=1;j<grid[0].length;j++){
                if(a<grid[i][j]){
                    a=grid[i][j];
                }
            }
            y[i]=a;
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                num+=(Math.min(x[j],y[i])-grid[i][j]);
            }
        }
        return num;
    }
}
