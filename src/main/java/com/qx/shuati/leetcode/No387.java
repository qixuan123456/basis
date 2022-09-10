package com.qx.shuati.leetcode;

import java.util.HashMap;

public class No387 {
    public static void main(String[] args) {
        String s = "123";
        System.out.println(firstUniqChar(s));
    }
    public static int firstUniqChar(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(map.getOrDefault(s.charAt(i),0)!=0){
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
                continue;
            }
            map.put(s.charAt(i),1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i))==1)
                return i;
        }
        return -1;
    }
}
