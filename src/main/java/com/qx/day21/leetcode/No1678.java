package com.qx.day21.leetcode;

public class No1678 {
    public static void main(String[] args) {
        String command = "(al)G(al)()()G";
        String s="";
        for (int i = 0; i < command.length(); i++) {
            if(command.charAt(i)=='('){
                if(command.charAt(i+1)==')'){
                    s=s+"o";
                }
                else {
                    s=s+"al";
                }
            }
            if(command.charAt(i)=='G'){
                s=s+"G";
            }
        }
        System.out.println(s);
    }
}
