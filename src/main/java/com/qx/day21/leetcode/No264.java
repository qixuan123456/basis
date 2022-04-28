package com.qx.day21.leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author Xuan
 * Date: 2022/3/22
 * Time: 11:07
 */
public class No264 {

    public static void main(String[] args) {

    }

    public int nthUglyNumber(int n) {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        long[] nums = {2,3,5};
        long poll = 1;
        queue.add(1L);
        for (int i = 0; i < n; i++) {
            poll = queue.poll();
            for(long num:nums){
                long c = poll*num;
                if(set.add(c)){
                    queue.offer(c);
                }
            }
        }
        return (int)poll;
    }
}
