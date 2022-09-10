package com.qx.shuati.leetcode;

/**
 * @author xuan
 * @date 2022/4/21 15:43
 */
public class No214 {

    public static void main(String[] args) {
        System.out.println(shortestPalindrome("abcd"));
    }

    public static String shortestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int r = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            int left = 0,right = i;
            while(left<right){
                if(chars[left]==chars[right]){
                    left++;
                    right--;
                }else {
                    break;
                }
            }
            if(left>=right){
                r = i;
                break;
            }
        }

        return new StringBuilder(s.substring(r+1)).reverse().append(s).toString();

    }
}
