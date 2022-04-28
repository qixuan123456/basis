package com.qx.shuati.niuke.alibaba2021;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/4/14 20:57
 */
public class No7 {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        // n 个牛牛
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
            if (a[i] < 1 || a[i] > 1000000) {
                return;
            }
        }
        int[] v = new int[a.length];
        Arrays.fill(v, 1);
        int k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            a[x - 1] += a[y - 1];
            v[x - 1] += 1;
            v[y - 1] = 0;
        }
        int[][] opt = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < m+1; j++) {
                if(j>=a[i-1]){
                    opt[i][j] = Math.max(opt[i-1][j],opt[i-1][j-a[i-1]]+v[i-1]);
                }else{
                    opt[i][j] = opt[i-1][j];
                }
            }
        }
        System.out.println(opt[n][m]);
    }
}
