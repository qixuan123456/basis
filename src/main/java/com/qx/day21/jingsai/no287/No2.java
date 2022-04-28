package com.qx.day21.jingsai.no287;

import java.util.*;

/**
 * @author Xuan
 * Date: 2022/4/8
 * Time: 19:28
 */
public class No2 {
    public static void main(String[] args) {
        No2 no2 = new No2();
        int[][] matches = {
                {1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {10, 4}, {10, 9}};
        System.out.println(no2.findWinners(matches));
    }

    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] match : matches) {

            if (!map.containsKey(match[0])) {
                map.put(match[0], 0);
            }
            map.put(match[1], map.getOrDefault(match[1], 0) + 1);

        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 0) {
                l1.add(entry.getKey());
            } else if (entry.getValue() == 1) {
                l2.add(entry.getKey());
            }
        }
        l1.sort(Integer::compareTo);
        l2.sort(Integer::compareTo);
        list.add(l1);
        list.add(l2);
        return list;
    }
}
