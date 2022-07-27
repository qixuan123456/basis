package com.qx.day21.jianzhi2;

/**
 * @author xuan
 * @date 2022/7/4 15:44
 */
public class No43 {
    public int countDigitOne(int n) {
        int ans = 0;
        int i = 1;
        int b = 0;
        int c = 0;
        while (n > 0) {
            int a = n % 10;
            ans = ans + (a * b) + (a == 0 ? 0 : (a == 1 ? c : i));
            b = b * 10 + i;
            c = a * i + c;
            i = i * 10;
            n = n / 10;
        }
        return ans;
    }
}
