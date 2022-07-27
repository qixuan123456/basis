package com.qx.day21.jingsai;

import java.util.*;

/**
 * @author xuan
 * @date 2022/7/21 20:35
 */
public class No262 {

    public static void main(String[] args) {
        System.out.println(twoOutOfThree(new int[]{1,2},new int[]{2,3},new int[]{1,3}));
    }

    public static List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> ans = new HashSet<>();
        for (int j : nums1) {
            set.add(j);
        }

        for (int j : nums2) {
            set1.add(j);
        }

        for (int i : set1) {
            if(!set.add(i)){
                ans.add(i);
            }
        }
        set1.clear();
        for (int j : nums3) {
            set1.add(j);
        }

        for (int j : set1) {
            if (!set.add(j)) {
                ans.add(j);
            }
        }
        return new ArrayList<>(ans);
    }

    static class StockPrice {

        PriorityQueue<int[]> small = new PriorityQueue<>((a,b)->a[1]-b[1]);
        PriorityQueue<int[]> big = new PriorityQueue<>((a,b)->b[1]-a[1]);
        Map<Integer,int[]> map = new HashMap<>();
        int maxTime = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        public StockPrice() {

        }

        public void update(int timestamp, int price) {
            if(map.containsKey(timestamp)){
                int[] v = map.get(timestamp);
                v[1] = price;
            }else {
                int[] n = new int[]{timestamp,price};
                map.put(timestamp,n);
                small.add(n);
                big.add(n);
            }
            if(timestamp>=maxTime){
                max = price;
            }
        }

        public int current() {
            return max;
        }

        public int maximum() {
            if(!big.isEmpty()){
                big.add(big.poll());
                return big.peek()[1];
            }else {
                return 0;
            }
        }

        public int minimum() {
            if(!small.isEmpty()){
                small.add(small.poll());
                return small.peek()[1];
            }else {
                return 0;
            }
        }
    }
}
