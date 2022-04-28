package com.qx.day21.leetcode;

public class No8 {
    public static void main(String[] args) {
        String s = "-42222222222222222222";
        System.out.println(myAtoi(s));
    }
    public static int myAtoi(String s) {
        long a = 0L;
        int i = 0;
        boolean flag = true;
        while (true){
            if(s.charAt(i)==' '){
                i++;
            }
            else {
                break;
            }
        }
        if(s.charAt(i)=='-'){
            i++;
            flag = false;
        }
        while (i<s.length()){
            if(s.charAt(i)<'0'||s.charAt(i)>'9'){
                break;
            }
            a = a*10+s.charAt(i)-'0';
            if((flag&&a>=2147483647L)){
                return 2147483647;
            }
            else if(!flag&&a>=2147483648L){
                return -2147483648;
            }
            i++;
        }
        if(!flag){
            a=-a;
        }
        return (int)a;
    }
}
