package com.qx.shuati.leetcode;

import java.util.*;

/**
 * @author Xuan
 * Date: 2021/12/30
 * Time: 18:53
 */
public class No846 {

    public static void main(String[] args) {
        System.out.println(isNStraightHand(new int[]{1, 2, 3, 9, 2, 3, 4, 7, 8}, 3));
    }

    public static boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for (int j : hand) {
            map.put(j, map.getOrDefault(j, 0) + 1);
        }

        while(!map.isEmpty()){
            Map.Entry<Integer, Integer> firstEntry = map.firstEntry();
            int a = firstEntry.getKey()+groupSize-1;
            if(!map.containsKey(a)){
                return false;
            }
            Set<Map.Entry<Integer, Integer>> entrySet= map.headMap(a,true).entrySet();
            Iterator<Map.Entry<Integer, Integer>> iterator = entrySet.iterator();
            while (iterator.hasNext()){
                Map.Entry<Integer, Integer> entry = iterator.next();
                if (entry.getValue() < firstEntry.getValue()) {
                    return false;
                } else if (entry.getValue().equals(firstEntry.getValue())) {
                    iterator.remove();
                } else {
                    map.put(entry.getKey(), entry.getValue() - firstEntry.getValue());
                }
            }
        }

        return true;

    }

//    public static boolean isNStraightHand(int[] hand, int groupSize) {
//        if (hand.length % groupSize != 0) {
//            return false;
//        }
//        Arrays.sort(hand);
//        int sum = 0;
//        int a = hand[0];
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < hand.length; i++) {
//            if (hand[i] == a) {
//                sum++;
//            } else {
//                map.put(a, sum);
//                a = hand[i];
//                sum = 1;
//            }
//            if (i == hand.length - 1) {
//                map.put(a, sum);
//            }
//        }
//        int count = hand.length / groupSize;
//        int first = hand[0];
//        int newfirst = 0;
//        for (int i = 0; i < count; i++) {
//            boolean flag = true;
//            for (int j = 0; j < groupSize; j++) {
//
//                int b = map.getOrDefault(first + j, 0);
//                if (b == 0) {
//                    return false;
//                } else if (b == 1) {
//                    map.put(first + j, 0);
//                } else {
//                    map.put(first + j, b - 1);
//                    if (flag) {
//                        newfirst = first + j;
//                        flag = false;
//                    }
//                }
//                if(j==groupSize-1){
//                    if(flag){
//                        if(i*groupSize+j+1< hand.length)
//                        first = hand[i*groupSize+j+1];
//                    }else {
//                        first = newfirst;
//                    }
//                }
//            }
//        }
//        return true;
//    }
}
