package com.qx.shuati.leetcode;

import java.util.HashMap;
import java.util.Map;

public class No350 {
    public static void main(String[] args) {
//        int nums[] ={1,2,2,3,4,5};
//
//        List<Integer> list1 = new ArrayList<>();
//        List<Integer> list2 = new ArrayList<>();
//        for (int i = 0; i <nums.length; i++) {
//            list1.add(nums[i]);
//        }
//        for (int i = 0; i < nums.length; i++) {
//            for (Integer I:list1) {
//                if(I==nums[i]){
//                    list1.remove(list1.get(I));
//                    list2.add(I);
//                    break;
//                }
//            }
//        }
//        Integer bb[]={};
//        list2.toArray( bb);

        Map<Integer,Integer> map= new HashMap<>();

        System.out.println(map.getOrDefault(1,10));
        map.put(2,5);
        System.out.println(map.getOrDefault(1,10));

        System.out.println(map.getOrDefault(2,10));
    }
}
