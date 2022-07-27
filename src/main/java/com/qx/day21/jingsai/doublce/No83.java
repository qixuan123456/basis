package com.qx.day21.jingsai.doublce;

import java.util.*;

/**
 * @author xuan
 * @date 2022/7/25 19:56
 */
public class No83 {

    public String bestHand(int[] ranks, char[] suits) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < ranks.length; i++) {
            set.add(suits[i]);
        }
        if (set.size() == 1) {
            return "Flush";
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < ranks.length; i++) {
            int a = map.getOrDefault(ranks[i], 0);
            if (a == 2) {
                return "Three of a Kind";
            }
            map.put(ranks[i], a + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 2) {
                return "Pair";
            }
        }
        return "High Card";
    }

    public long zeroFilledSubarray(int[] nums) {
        long numZero = 0;
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                numZero++;
            }else{
                ans+=(numZero*(numZero+1))/2;
                numZero = 0;
            }
        }

        ans+=(numZero*(numZero+1))/2;
        return ans;
    }

    static class NumberContainers {
        TreeMap<Integer,Integer> map = new TreeMap<>((a,b)->{return a-b;});
        public NumberContainers() {

        }

        public void change(int index, int number) {
            map.put(index,number);
        }

        public int find(int number) {
            if(!map.containsValue(number)){
                return -1;
            }

            for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
                if(entry.getValue()==number){
                    return entry.getKey();
                }
            }
            return -1;
        }
    }
}
