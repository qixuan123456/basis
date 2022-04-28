package com.qx.day21.leetcode;

import java.util.*;

/**
 * @author Xuan
 * Date: 2021/11/27
 * Time: 17:14
 */
public class No519 {

    public static void main(String[] args) {

    }

    static class Solution {
        int m;
        int n;
        int sum;
        Map<Integer,Integer> map = new HashMap<>();
        Random random = new Random();

        public Solution(int m, int n) {
            this.m=m;
            this.n=n;
            this.sum = n*m;
        }

        public int[] flip() {
            int r = random.nextInt(sum);
            sum--;
            int current = map.getOrDefault(r,r);
            map.put(r,map.getOrDefault(r,sum));
            return new int[]{current/n,current%n};
        }

        public void reset() {
            map.clear();
            sum=n*m;
        }
    }

}
