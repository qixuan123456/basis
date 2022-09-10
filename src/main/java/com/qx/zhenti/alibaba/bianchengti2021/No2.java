package com.qx.zhenti.alibaba.bianchengti2021;

import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/8/3 15:47
 */
public class No2 {
    static int mod = (int) (1e9 + 7);
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            int m = scanner.nextInt();

            System.out.println(get(A, B, m));
        }
    }

    public static int get(int A, int B, int m) {
        long[] dp = new long[m + 1];
        dp[1] = A;
        dp[2] = (long) A * A - 2L * B;
        for (int i = 3; i <= m; i++) {
            dp[i] = ((dp[i-1]*A)%mod+mod-(dp[i-2]*B)%mod)%mod;
        }
        return (int) dp[m];
    }
}
