package com.qx.day21.leetcode;

/**
 * User: xuan
 * Date: 2021/10/8
 * Time: 15:53
 */
public class No2027 {
    public static void main(String[] args) {
        String s = "XXXO";
        No2027 no2027 = new No2027();
        System.out.println(no2027.minimumMoves(s));
    }

    public int minimumMoves(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='X'){
                res++;
                i+=2;
            }
        }
        return res;
    }
}

