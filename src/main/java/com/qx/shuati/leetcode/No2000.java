package com.qx.shuati.leetcode;

public class No2000 {
    public static void main(String[] args) {
        String word = "abcdefd";
        char ch = 'd';
        System.out.println(reversePrefix(word,ch));
    }
    public static String reversePrefix(String word, char ch) {

        String[] ss = word.split(String.valueOf(ch),2);
        if(ss.length==1){
            return word;
        }
        StringBuilder sb = new StringBuilder(ss[0]);
        sb.append(ch);
        return sb.reverse().append(ss[1]).toString();
    }
}
