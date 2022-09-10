package com.qx.shuati.leetcode;

/**
 * User: xuan
 * Date: 2021/10/7
 * Time: 19:44
 */
public class No434 {

    public static void main(String[] args) {
        String s = "Hello, my name is John";
        No434 no434 = new No434();
        System.out.println(no434.countSegments(s));
    }

    public int countSegments(String s) {
        boolean flag = true;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                if (flag) {
                    res++;
                    flag = false;
                }
            } else {
                flag = true;
            }
        }
        return res;
    }
}
