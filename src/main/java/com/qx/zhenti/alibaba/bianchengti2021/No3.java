package com.qx.zhenti.alibaba.bianchengti2021;

import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/8/2 22:00
 */
public class No3 {
    static int mod = (int) (1e9 + 7);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        System.out.println(get(n, m));
    }

    public static int get(int n, int m) {
        long[][] dp = new long[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 0; k < j; k++) {
                    dp[i][j] = (dp[i][j] + (dp[i - 1][k] * dp[i - 1][j - 1 - k]) % mod) % mod;
                }
            }
        }
        return (int) dp[m][n];
    }
}
