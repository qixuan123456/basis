package com.qx.shuati.leetcode;

public class No1884 {
    public static void main(String[] args) {
        String s="a1c1";
        System.out.println(replaceDigits(s));
    }
    public static String replaceDigits(String s) {
        String ss = "";
        for(int i=0;i<s.length();i++){
            if(i%2==0){
                ss+=s.charAt(i);
            }
            else{
                ss+=shift(s.charAt(i-1),(int)(s.charAt(i)-'0'));
            }
        }
        return ss;
    }
    public static char shift(char c,int n){

        return (char) (c+n);
    }
}
