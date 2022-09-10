package com.qx.shuati.jingsai.no1;

/**
 * @author Xuan
 * Date: 2021/12/30
 * Time: 19:52
 */
public class no1 {
    public static void main(String[] args) {

    }
    public String firstPalindrome(String[] words) {
        for (int i = 0; i < words.length; i++) {
            if(isPalindrome(words[i])){
                return words[i];
            }
        }
        return "";
    }
    public boolean isPalindrome(String word){
        char[] chars = word.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len/2; i++) {
            if(chars[i]!=chars[len-1-i]){
                return false;
            }
        }
        return true;
    }
}
