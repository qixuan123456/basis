package com.qx.zhenti.alibaba.bianchengti2021;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/8/3 17:04
 */
public class No7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        int[][] t = new int[k][2];
        for (int i = 0; i < k; i++) {
            t[i][0] = scanner.nextInt();
            t[i][1] = scanner.nextInt();
        }
        init(n,a);
        for (int i = 0; i < k; i++) {
            put(t[i][0] - 1, t[i][1] - 1);
        }
        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = dp[i-1][j];
                if(j>=weight[i-1]){
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][j-weight[i-1]]+shu[i-1]);
                }
            }
        }
        System.out.println(dp[n][m]);

    }

    static int[] group;
    static int[] weight;
    static int[] shu;
    public static void init(int n,int[] a) {
        group = new int[n];
        weight = new int[n];
        shu = new int[n];
        for (int i = 0; i < n; i++) {
            group[i] = i;
            weight[i] = a[i];
            shu[i] = 1;
        }
    }

    public static int get(int i) {
        if (i != group[i]) {
            return get(group[i]);
        }
        return group[i];
    }

    public static void put(int a, int b) {
        a = get(a);
        b = get(b);
        if (weight[a] > weight[b]) {
            group[b] = a;
            weight[a] += weight[b];
            weight[b] = 0;
            shu[a] +=shu[b];
            shu[b] = 0;
        } else {
            group[a] = b;
            weight[b] += weight[a];
            weight[a] = 0;
            shu[b] +=shu[a];
            shu[a] = 0;
        }
    }

}
