package com.qx.shuati.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xuan
 * @date 2022/5/17 10:49
 */
public class No953 {

    public static void main(String[] args) {
        No953 no953 = new No953();
        String[] words = {"word","world","row"};
        String order = "worldabcefghijkmnpqstuvxyz";
        System.out.println(no953.isAlienSorted(words,order));

    }
    private final Map<Character,Integer> map = new HashMap<>();
    public boolean isAlienSorted(String[] words, String order) {

        for (int i = 0; i < 26; i++) {
            map.put(order.charAt(i),i);
        }

        for (int i = 0; i < words.length-1; i++) {
            if(!compare(words[i],words[i+1])){
                return false;
            }
        }
        return true;
    }

    public boolean compare(String s1,String s2){
        int len = Math.min(s1.length(),s2.length());
        for (int i = 0; i < len; i++) {
            int a = map.get(s1.charAt(i));
            int b = map.get(s2.charAt(i));
            if(a>b){
                return false;
            }else if(a<b) {
                return true;
            }
        }
        return s1.length() <= s2.length();
    }
}
