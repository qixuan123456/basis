package com.qx.day21.leetcode;

import java.util.Arrays;

/**
 * @author xuan
 * @date 2022/4/16 12:23
 */
public class No479 {
    public static void main(String[] args) {
        //test(8);
        String s = "dddd dsd, s.";
        System.out.println(Arrays.toString(s.split("s|.")));
    }
    public int largestPalindrome(int n) {
        long a = (long)Math.pow(10,n)-1;
        long b = a * a;
        StringBuilder sb = new StringBuilder();
        String s = Long.toString(b);
        for (int i = 0; i < n; i++) {
            if(s.charAt(i)=='9'){
                sb.append(9);
            }else{
                sb.append((s.charAt(i)-1));
                break;
            }
        }
        sb.append(sb.reverse());

        return  (int)(Long.parseLong(sb.toString())%1337);
    }

    public static void test(int n){
        long a = (long)Math.pow(10,n)-1;
        long b = (long)Math.pow(10,n-1)*9;
        long res = 0L;
        for (long i = a; i >= b; i--) {
            for (long j = i; j >= b; j--) {
                if(i*j>res&&check(i*j)){
                    res = Math.max(res,i*j);
                    System.out.println("i = "+i+"   j = "+j+" = "+i*j);
                }
            }
        }
        System.out.println(res);
        System.out.println(res%1337);
    }
    public static boolean check(long a){
        char[] chars = Long.toString(a).toCharArray();
        for (int i = 0; i < (chars.length+1)/2; i++) {
            if(chars[i]!=chars[chars.length-1-i]){
                return false;
            }
        }
        return true;
    }
}
