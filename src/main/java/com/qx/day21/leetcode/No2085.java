package com.qx.day21.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xuan
 * Date: 2021/12/1
 * Time: 20:35
 */
public class No2085 {
    public static void main(String[] args) {

    }
    public int countWords(String[] words1, String[] words2) {
        Map<String,Integer> map1 = new HashMap<>();
        Map<String,Integer> map2 = new HashMap<>();
        int res = 0;
        for (String s : words1) {
            map1.put(s, map1.getOrDefault(s, 0) + 1);
        }
        for (String s : words2) {
            map2.put(s, map2.getOrDefault(s, 0) + 1);
        }
        for (Map.Entry<String,Integer> a:map1.entrySet()){
            if(a.getValue()==1){
                if(map2.getOrDefault(a.getKey(),0)==1){
                    res++;
                }
            }
        }
        return res;
    }
}
