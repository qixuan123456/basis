package com.qx.shuati.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xuan
 * @date 2022/4/27 16:00
 */
public class No417 {
    public static void main(String[] args) {
        int[][] heights = {{2,2,2},{2,1,2},{2,2,2}};
        No417 no417 = new No417();
        System.out.println(no417.pacificAtlantic(heights));
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> lists = new ArrayList<>();
        int cow  = heights.length;
        int column = heights[0].length;
        boolean[][] flag = new boolean[cow][column];
        int[][][] a = new int[cow][column][2];

        for(int i=0;i<cow;i++){
            for(int j=0;j<column;j++){
                if(a[i][j][0]==0||a[i][j][1]==0)
                dfs(heights,i,j,flag,a);
            }
        }
        for (int i = 0; i < cow; i++) {
            for (int j = 0; j < column; j++) {
                if(a[i][j][0]==1&&a[i][j][1]==1){
                    lists.add(Arrays.asList(i,j));
                }
            }
        }
        return lists;
    }

    public void dfs(int[][] heights, int cow, int column, boolean[][] flag, int[][][]a){
        flag[cow][column] = true;

        if(cow-1<0){
            a[cow][column][0] = 1;
        }else if(heights[cow][column]>=heights[cow-1][column]){
            if(!flag[cow-1][column]){
                dfs(heights,cow-1,column,flag,a);
                a[cow][column][0]=Math.max(a[cow-1][column][0],a[cow][column][0]);
                a[cow][column][1]=Math.max(a[cow-1][column][1],a[cow][column][1]);
                if(a[cow][column][0]==0||a[cow][column][1]==0){
                    flag[cow-1][column]=false;
                }

            }else{
                a[cow][column][0]=Math.max(a[cow-1][column][0],a[cow][column][0]);
                a[cow][column][1]=Math.max(a[cow-1][column][1],a[cow][column][1]);
            }
        }

        if(cow+1>=heights.length){
            a[cow][column][1] = 1;
        }else if(heights[cow][column]>=heights[cow+1][column]){
            if(!flag[cow+1][column]){
                dfs(heights,cow+1,column,flag,a);
                a[cow][column][0]=Math.max(a[cow+1][column][0],a[cow][column][0]);
                a[cow][column][1]=Math.max(a[cow+1][column][1],a[cow][column][1]);
                if(a[cow][column][0]==0||a[cow][column][1]==0){
                    flag[cow+1][column]=false;
                }

            }else{
                a[cow][column][0]=Math.max(a[cow+1][column][0],a[cow][column][0]);
                a[cow][column][1]=Math.max(a[cow+1][column][1],a[cow][column][1]);
            }
        }

        if(column-1<0){
            a[cow][column][0] = 1;
        }else if(heights[cow][column]>=heights[cow][column-1]){
            if(!flag[cow][column-1]){
                dfs(heights,cow,column-1,flag,a);
                a[cow][column][0]=Math.max(a[cow][column-1][0],a[cow][column][0]);
                a[cow][column][1]=Math.max(a[cow][column-1][1],a[cow][column][1]);
                if(a[cow][column][0]==0||a[cow][column][1]==0){
                    flag[cow][column-1]=false;
                }

            }else{
                a[cow][column][0]=Math.max(a[cow][column-1][0],a[cow][column][0]);
                a[cow][column][1]=Math.max(a[cow][column-1][1],a[cow][column][1]);
            }
        }

        if(column+1>=heights[0].length){
            a[cow][column][1] = 1;
        }else if(heights[cow][column]>=heights[cow][column+1]){
            if(!flag[cow][column+1]){
                dfs(heights,cow,column+1,flag,a);
                a[cow][column][0]=Math.max(a[cow][column+1][0],a[cow][column][0]);
                a[cow][column][1]=Math.max(a[cow][column+1][1],a[cow][column][1]);

                if(a[cow][column][0]==0||a[cow][column][1]==0){
                    flag[cow][column+1]=false;
                }
            }else{
                a[cow][column][0]=Math.max(a[cow][column+1][0],a[cow][column][0]);
                a[cow][column][1]=Math.max(a[cow][column+1][1],a[cow][column][1]);
            }
        }
    }
}
