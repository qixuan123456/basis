package com.qx.shuati.leetcode;

/**
 * @author Xuan
 * Date: 2021/12/4
 * Time: 16:38
 */
public class No383 {

    public static void main(String[] args) {
        String ransomNote = "a";
        String magazine = "b";
        System.out.println(canConstruct(ransomNote,magazine));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] character = new int[26];
        for(int i=0;i<magazine.length();i++){
            character[magazine.charAt(i)-'a']++;
        }
        for(int i=0;i<ransomNote.length();i++){
            if(--(character[ransomNote.charAt(i)-'a'])<0){
                return false;
            }
        }
        return true;
    }
}
