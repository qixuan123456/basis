package com.qx.day21.leetcode;

import java.util.Arrays;

/**
 * @author xuan
 * @date 2022/7/4 14:25
 */
public class No556 {

    public static void main(String[] args) {

    }

    public int nextGreaterElement(int n) {
        char[] chars = String.valueOf(n).toCharArray();

        for (int i = chars.length-2; i >= 0; i--) {
            if(chars[i]<chars[i+1]){
                for (int j = chars.length-1; j >= 0; j--) {
                    if(chars[j]>chars[i]){
                        char c = chars[i];
                        chars[i] = chars[j];
                        chars[j] = c;
                        Arrays.sort(chars,i+1,chars.length);
                        break;
                    }
                }
                long res = Long.parseLong(new String(chars));
                return res>Integer.MAX_VALUE?-1:(int)res;
            }
        }
        return -1;
    }
}
