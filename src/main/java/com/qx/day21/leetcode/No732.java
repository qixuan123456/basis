package com.qx.day21.leetcode;

import java.util.TreeMap;

/**
 * @author xuan
 * @date 2022/6/6 13:21
 */
public class No732 {
    static class MyCalendarThree {
        TreeMap<Integer, Integer> tree = new TreeMap<>();
        TreeMap<Integer, Integer> lazy = new TreeMap<>();

        public MyCalendarThree() {

        }

        public int book(int start, int end) {
            update(start, end - 1, 0, 1000000000, 1);
            return tree.getOrDefault(1, 0);
        }

        public void update(int start, int end, int l, int r, int id) {
            if (start > r || end < l) {
                return;
            }
            if (start <= l && end >= r) {
                tree.put(id, tree.getOrDefault(id, 0) + 1);
                lazy.put(id, lazy.getOrDefault(id, 0) + 1);
            } else {
                int mid = (l + r) >> 1;
                update(start, end, l, mid, 2 * id);
                update(start, end, mid + 1, r, 2 * id + 1);
                tree.put(id, lazy.getOrDefault(id, 0) + Math.max(tree.get(2 * id), tree.get(2 * id + 1)));
            }
        }
    }
}
