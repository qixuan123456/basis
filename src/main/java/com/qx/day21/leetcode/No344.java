package com.qx.day21.leetcode;


import com.qx.day21.tool.Util;

public class No344 {
    public static void main(String[] args) {
        char[] s ={'h','e','l','l','o'};
        reverseString(s);
        Util.printArray(s);
    }
    public static void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char a = s[i];
            s[i] = s[s.length-i-1];
            s[s.length-i-1] = a;
        }
    }
}
