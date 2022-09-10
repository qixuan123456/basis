package com.qx.shuati.leetcode;

import java.util.*;

/**
 * User: xuan
 * Date: 2021/10/12
 * Time: 18:40
 */
public class No2032 {
    public static void main(String[] args) {
        No2032 no2032 = new No2032();
        int[] nums1 = {1, 2, 3, 5};
        int[] nums2 = {2, 3, 1, 5, 4};
        int[] nums3 = {0, 2, 1, 4, 7};
        System.out.println(no2032.twoOutOfThree(nums1, nums2, nums3));
    }

    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Map<Integer,Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int a : nums1) {
            map.put(a,1);
        }
        for (int a : nums2) {
           if(map.getOrDefault(a,0)==1){
               set.add(a);
           }
        }
        for (int a : nums2) {
            map.put(a,1);
        }
        for (int a : nums3) {
            if(map.getOrDefault(a,0)>0){
                set.add(a);
            }
        }
        return new ArrayList<>(set);
    }
}
