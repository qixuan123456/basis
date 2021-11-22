package day21.leetcode;

import java.util.*;

public class No347 {
    public static void main(String[] args) {
        int[] nums={1,1,1,2,2,3,3,3};
        int k =2;
        int[] a = topKFrequent(nums,k);
        for (int value : a) {
            System.out.println(value);
        }
    }
    public static int[] topKFrequent(int[] nums, int k) {
        int[] a = new int[k];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());
        int l = list.size();
        for (int i = 0; i < k; i++) {
            a[i] = list.get(l-1-i).getKey();
        }
        return a;
    }
}
