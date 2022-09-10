package com.qx.shuati.leetcode;

public class No844 {
    public static void main(String[] args) {
        String s = "ac##";
        String t = "a#c#";
        System.out.println(backspaceCompare(s,t));
    }
    public static boolean backspaceCompare(String s, String t) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)!='#'){
                s1.append(s.charAt(i));
            }
            else if(s1.length()>0){
                s1.delete(s1.length()-1,s1.length());
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if(t.charAt(i)!='#'){
                s2.append(t.charAt(i));
            }
            else if(s2.length()>0){
                s2.delete(s2.length()-1,s2.length());
            }
        }
        return s1.toString().equals(s2.toString());
    }
}
