package com.qx.day21.leetcode;

/**
 * User: xuan
 * Date: 2021/10/2
 * Time: 16:02
 */
public class No405 {
    public static void main(String[] args) {
        System.out.println(toHex(0));
    }

    public static String toHex(int num) {
        char[] chars = {
                '0','1','2','3','4','5','6','7',
                '8','9','a','b','c','d','e','f'};


        char[] a = Integer.toBinaryString(num).toCharArray();
        char[] res = new char[Math.max((a.length+3)/4,1)];
        int j =0;
        int b = 0;
        int flag = 4-a.length%4;
        for (char c : a) {
            flag++;
            b = b * 2 + (c - '0');
            if (flag % 4 == 0) {
                res[j] = chars[b];
                j++;
                b = 0;
            }
        }

        return new String(res);
    }
}
