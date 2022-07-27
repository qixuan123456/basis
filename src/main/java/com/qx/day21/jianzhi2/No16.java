package com.qx.day21.jianzhi2;

/**
 * @author xuan
 * @date 2022/7/1 14:58
 */
public class No16 {
    public static void main(String[] args) {
        System.out.println(new No16().myPow(2, -10));
    }

    public double myPow(double x, int n) {
        boolean flag = n >= 0;
        double ans = 1;
        double temp = x;
        n = Math.abs(n);
        for (int i = 0; i < 32; i++) {
            if (((n >> i) & 1) == 1) {
                ans *= temp;
            }
            temp = temp * temp;
        }
        if (flag) {
            return ans;
        } else {
            return 1/ans;
        }
    }
}
