package com.qx.shuati.jianzhi2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xuan
 * Date: 2021/11/25
 * Time: 19:57
 */
public class No017 {
    public static void main(String[] args) {
        No017 no017 = new No017();
        String s = "ab";
        String t = "ab";
        System.out.println(no017.minWindow(s,t));
    }

    public String minWindow(String s, String t) {
//        if(s.equals(t)){
//            return s;
//        }
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> map1 = new HashMap<>();
        int left = 0, right = 0;
        int res = Integer.MAX_VALUE;
        int l = 0,r = 0;
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        while (left < s.length() && right < s.length()+1) {

            if (isTrue(map, map1)) {
                if(right-left<res){
                    l = left;
                    r = right;
                }
                res = Math.min(res,right-left+1);
                map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 0) - 1);
                left++;
            } else {
                if(right<s.length()) {
                    map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
                }
                right++;
            }

        }
        if (isTrue(map, map1)) {
            if(right-left<res){
                l = left;
                r = right;
            }
        }
        return s.substring(l,r);
    }

    public boolean isTrue(Map<Character, Integer> map, Map<Character, Integer> map1) {

        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            if(!map.containsKey(entry.getKey())||map.get(entry.getKey())<entry.getValue()){
                return false;
            }
        }
        return true;
    }
}
