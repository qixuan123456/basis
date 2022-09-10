package com.qx.shuati.leetcode;

/**
 * @author xuan
 * @date 2022/4/18 12:15
 */
public class No1922 {

    public static void main(String[] args) {
        System.out.println(countGoodNumbers(4));

    }

    public static int countGoodNumbers(long n) {
        if (n == 1) {
            return 5;
        }
        long[] ans = new long[50];
        long res = 1L;
        ans[0] = 5L;
        ans[1] = 20L;
        for (int i = 2; i < 50; i++) {
            ans[i] = (ans[i - 1] * ans[i - 1]) % 1000000007;
        }
        for (int i = 49; i > 0; i--) {
            long a = (long) Math.pow(2, i);
            if (n >= Math.pow(2, i)) {
                res *= ans[i];
                res %= 1000000007;
                i++;
                n -= a;
            }
        }
        return (int) (res % 1000000007);
    }
}
