package com.qx.day21.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * User: xuan
 * Date: 2021/10/3
 * Time: 16:02
 */
public class No137 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,3,3,2,2};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num:nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }

        for (Map.Entry<Integer,Integer> r:map.entrySet()){
            if(r.getValue()!=3){
                return r.getKey();
            }
        }
        return -1;
    }

}
