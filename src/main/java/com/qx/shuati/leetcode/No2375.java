package com.qx.shuati.leetcode;

import java.util.Arrays;

/**
 * @author xuan
 * @date 2022/8/16 16:29
 */
public class No2375 {

    public static void main(String[] args) {
        System.out.println(smallestNumber("IIIDIDDD"));
    }

    public static String smallestNumber(String pattern) {

        char[] chars = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        int i = 0;
        while (i < pattern.length()) {
            while (i < pattern.length() && pattern.charAt(i) == 'I') {
                i++;
            }

            int i0 = i;
            while (i < pattern.length() && pattern.charAt(i) == 'D') {
                i++;
            }

            reserve(chars,i0,i);

        }
        return new String(chars,0,pattern.length()+1);
    }

    public static void reserve(char[] chars, int s, int e) {
        while(s<e){
            char c = chars[s];
            chars[s] = chars[e];
            chars[e] = c;
            s++;
            e--;
        }
    }
}
