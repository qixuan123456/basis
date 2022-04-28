package com.qx.shuati.niuke.alibaba2021;

import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/4/14 19:59
 */
public class No8 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        while(x-->0){
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[][] nums = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    nums[i][j] = sc.nextInt();
                }
            }
            int[][] res = new int[m+1][n+1];
            res[1][1] = 1;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int c = nums[i][j];
                    if(c>0){
                        for (int k = 0; k <= c; k++) {
                            for (int l = 0; l <= c - k; l++) {
                                if((k!=0||l!=0)&&i+k<m&&j+l<n){
                                    res[i+k+1][j+l+1] +=res[i+1][j+1];
                                    res[i+k+1][j+l+1]%=10000;
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(res[m][n]%10000);
        }
    }
}
