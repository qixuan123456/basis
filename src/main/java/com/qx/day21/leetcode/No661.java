package com.qx.day21.leetcode;

import java.util.Arrays;

/**
 * @author Xuan
 * Date: 2022/3/24
 * Time: 13:33
 */
public class No661 {
    public static void main(String[] args) {
        
        int[][] img = {{2,3,4},{5,6,7},{8,9,10},{11,12,13},{14,15,16}};
        No661 no661 = new No661();
        System.out.println(Arrays.toString(no661.imageSmoother(img)));
    }

    public int[][] imageSmoother(int[][] img) {
        int y=img.length;
        int x=img[0].length;
        int[][] ans=new int[y][x];
        for(int i=0;i<y;i++){
            for(int j=0;j<x;j++){
                ans[i][j]=averageOfSurround(img,i,j);
            }
        }
        return ans;
    }
    public int averageOfSurround(int[][] img,int y,int x){
        int sum=0;
        int count=0;
        int[][] offset={{-1,-1},{-1,0},{-1,1},
                {0,-1},{0,0},{0,1},
                {1,-1},{1,0},{1,1}};
        for(int k=0;k<9;k++){
            int yy=y+offset[k][0];
            int xx=x+offset[k][1];
            if(yy<0||yy>=img.length||xx<0||xx>=img[0].length){
                continue;
            }
            sum+=img[yy][xx];
            count++;
        }
        return sum/count;
    }
}
