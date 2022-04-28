package com.qx.day21.leetcode;

public class No5 {
    public static void main(String[] args) {
        String s = "bbad";
        System.out.println(longestPalindrome(s));
    }
    public static String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        int max = 0;
        String s1 = "";
        for (int i = 0; i < s.length(); i++) {
            int a = 0;
            int right = i;
            while(right+1<s.length()&&s.charAt(right+1)==s.charAt(i)){
                right++;
            }
            while(i-a>=0&&s.length()-right-a>0){
                if(s.charAt(i-a)!=s.charAt(right+a)){
                    break;
                }
                start = i-a;
                end = right+a;
                a++;
            }
            if(max<end-start+1){
                max =end-start+1 ;
                s1 = s.substring(start,end+1);
            }
        }
        return s1;
    }
}
