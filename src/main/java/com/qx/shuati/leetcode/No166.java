package com.qx.shuati.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * User: xuan
 * Date: 2021/10/3
 * Time: 15:22
 */
public class No166 {
    public static void main(String[] args) {
        System.out.println(fractionToDecimal(-4, 333));
    }

    public static String fractionToDecimal(int numerator, int denominator) {
        long n = (long) numerator;
        long d = (long) denominator;
        if (n % d == 0) {
            return String.valueOf(n / d);
        }
        StringBuilder sb = new StringBuilder();
        if (n < 0 ^ d < 0) {
            sb.append('-');
        }
        n = Math.abs(n);
        d = Math.abs(d);
        long a = n / d;
        long b = n % d;
        sb.append(a);
        sb.append('.');

        Map<Long, Integer> map = new HashMap<>();
        int c = sb.length();
        while (b != 0 && !map.containsKey(b)) {
            map.put(b, c);
            b = b * 10;
            a = b / d;
            b = b % d;
            sb.append(a);
            c++;
        }
        if (b != 0) {
            sb.insert(map.get(b).intValue(), '(');
            sb.append(')');
        }
        return sb.toString();
    }
}
