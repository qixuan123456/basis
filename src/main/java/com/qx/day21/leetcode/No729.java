package com.qx.day21.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xuan
 * @date 2022/7/5 12:57
 */
public class No729 {

    public boolean book(int start, int end) {
        if(get(start,end-1,0,n,1,0)>0){
            return false;
        }
        push(start,end-1,0,n,1);
        return true;
    }
    Map<Integer, Integer> tree = new HashMap<>();
    Map<Integer, Integer> cache = new HashMap<>();
    int n = 1000000000;

    public void push(int start, int end, int left, int right, int current) {
        if (end < left || start > right) {
            return;
        }
        if (start <= left && end >= right) {
            tree.put(current, tree.getOrDefault(current, 0) + (right - left + 1));
            cache.put(current, cache.getOrDefault(current, 0) + 1);
            return;
        }
        int mid = (left + right) >> 1;
        push(start, end, left, mid, 2 * current);
        push(start, end, mid+1, right, 2 * current + 1);
        tree.put(current, cache.getOrDefault(current, 0) * (right - left + 1) + tree.getOrDefault(2 * current, 0) + tree.getOrDefault(2 * current + 1, 0));
    }

    public int get(int start, int end, int left, int right, int current, int c) {
        if (end < left || start > right) {
            return 0;
        }
        if (start <= left && end >= right) {
            return tree.getOrDefault(current, 0)+c*(right-left+1);
        }
        int mid = (left + right) >> 1;
        c = c + cache.getOrDefault(current, 0);
        int l = get(start, end, left, mid, 2 * current, c);
        int r = get(start, end, mid + 1, right, 2 * current + 1, c);
        return l + r;
    }
}
