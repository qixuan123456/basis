package com.qx.shuati.leetcode;

import java.math.BigInteger;

/**
 * @author Xuan
 * Date: 2022/3/24
 * Time: 14:33
 */
public class No463 {
    public static void main(String[] args) {
        No463 no463 = new No463();
        int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        System.out.println(no463.islandPerimeter(grid));

        System.out.println(Math.pow(Math.E,26)*1000000);



        System.out.println(Math.log(new BigInteger("ffffffffffffffff",16).doubleValue()));
    }

    public int islandPerimeter(int[][] grid) {
        int ans = 0;
        int[][] offset = {{-1,0},{1,0},{0,-1},{0,1}};
        for(int i =0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                for(int k=0;k<4;k++){
                    if(grid[i][j]==1){
                        int y=i+offset[k][0];
                        int x=j+offset[k][1];
                        if(x<0||x>=grid[0].length||y<0||y>=grid.length){
                            ans++;
                        }else{
                            if(grid[y][x]==0){
                                ans++;
                            }
                        }
                    }

                }
            }
        }
        return ans;
    }
}
