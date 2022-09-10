package com.qx.zhenti.didi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/5/24 16:27
 */
public class No1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = sc.nextInt();
        }
        No1.no1(arr);
    }

    public static void no1(int[] arr){
        Arrays.sort(arr);
        if(Math.abs(arr[0]+arr[1]-arr[2])>1){
            System.out.println(1);
            return;
        }
        int[][] dp = new int[arr[0]+1][arr[1]+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if(i==0||j==0){
                    dp[i][j] = 1;
                }else {
                    dp[i][j] = dp[i][j-1]+dp[i-1][j];
                }
            }
        }
        int n = dp[arr[0]][arr[1]];

        if(Math.abs(arr[0]+arr[1]-arr[2])==0){
            System.out.println(3*n);
        }else {
            System.out.println(n);
        }

    }
}
