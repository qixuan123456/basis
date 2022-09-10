package com.qx.shuati.leetcode;

//不会
public class No91 {
    public static void main(String[] args) {
        String s = "10";
        System.out.println(numDecodings(s));

    }

    public static int numDecodings(String s) {
        if(s.charAt(0)=='0')
            return 0;
        if (s.length()<2){
            return s.length();
        }
        int[] res = new int[s.length()];
        res[0] = 1;
        if((s.charAt(0)=='2'&&s.charAt(1)<='6'&&s.charAt(1)>'0')||(s.charAt(0)=='1'&&s.charAt(1)>'0')){
            res[1] = 2;
        }else if(s.charAt(1)=='0'&&s.charAt(0)>'2'){
            res[1] = 0;
        }else {
            res[1] = 1;
        }
        for (int i = 2; i < s.length(); i++) {
            if(s.charAt(i)!='0'){
                res[i] = res[i-1];
            }
            if((s.charAt(i-1)=='1')||(s.charAt(i-1)>'0'&&s.charAt(i-1)<='2'&&s.charAt(i)<='6')){
                res[i] += res[i-2];
            }
        }
        return res[s.length()-1];
    }
}
