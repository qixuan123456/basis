package com.qx.day21.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author xuan
 * @date 2022/7/19 20:30
 */
public class No731 {

    TreeMap<Integer,Integer> map = new TreeMap<>();
    public No731() {

    }

    public boolean book(int start, int end) {
        map.put(start,map.getOrDefault(start,0)+1);
        map.put(end,map.getOrDefault(end,0)-1);
        int max = 0;
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            max+=entry.getValue();
            if(max>2){
                map.put(start,map.getOrDefault(start,0)-1);
                map.put(end,map.getOrDefault(end,0)+1);
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

    }
}
