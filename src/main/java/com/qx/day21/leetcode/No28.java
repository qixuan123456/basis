package com.qx.day21.leetcode;

public class No28 {
    public static void main(String[] args) {
        String haystack="abc";
        String needle="c";
        System.out.println(strStr(haystack,needle));
    }
    public static int strStr(String haystack, String needle) {
        if(needle==null)
            return 0;
        int flag=-1;
        for(int i=0;i<haystack.length()-needle.length()+1;i++){
            int j;
            for(j=i;j-i<needle.length();j++){
                if(haystack.charAt(j)==needle.charAt(j-i)){
                    continue;
                }
                else {
                    break;
                }
            }
            if(j-i==needle.length()){
                flag=i;
                return flag;
            }
        }
        return flag;
    }
}
