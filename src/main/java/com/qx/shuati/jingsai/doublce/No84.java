package com.qx.shuati.jingsai.doublce;

import java.util.*;

/**
 * @author xuan
 * @date 2022/8/11 15:34
 */
public class No84 {

    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {

        TreeMap<Integer,Integer> map = new TreeMap<>();
        for (int i = 0; i < items1.length; i++) {
            map.put(items1[i][0],map.getOrDefault(items1[i][0],0)+items1[i][1]);
        }
        for (int i = 0; i < items2.length; i++) {
            map.put(items2[i][0],map.getOrDefault(items2[i][0],0)+items2[i][1]);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            List<Integer> list = new ArrayList<>();
            list.add(entry.getKey());
            list.add(entry.getValue());
            ans.add(list);
        }
        return ans;
    }

    public long countBadPairs(int[] nums) {
        long ans = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i] - i;
            if (!map.containsKey(a)) {
                ans += sum;
            } else {
                ans += (sum - map.get(a));
            }
            map.put(a, map.getOrDefault(a, 0) + 1);
            sum++;
        }
        return ans;
    }

    public static long taskSchedulerII(int[] tasks, int space) {
        long current = 0;
        Map<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            if (!map.containsKey(tasks[i])) {
                map.put(tasks[i], current++);
            } else {
                long c = map.get(tasks[i]);
                current = Math.max(current, c + space + 1);
                map.put(tasks[i], current);
                current++;
            }
        }
        return map.get(tasks[tasks.length - 1]);
    }

    public static void main(String[] args) {
        System.out.println(minimumReplacement(new int[]{12,9,7,6,17,19,21}));
    }
    public static long minimumReplacement(int[] nums) {
        long ans = 0;
        int n = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            int a = (nums[i]-1) / n;
            if (a != 0) {
                ans += a;
                if (nums[i] % n != 0) {
                    n = nums[i]/(a+1);
                }
            }else {
                n = nums[i];
            }
        }
        return ans;
    }
}
