package com.qx.day21.leetcode;

import java.util.Arrays;

/**
 * User: xuan
 * Date: 2021/9/25
 * Time: 19:17
 */
public class No274 {
    public static void main(String[] args) {
        int[] citations = {15,10};
        System.out.println(hIndex(citations));
    }

    public static int hIndex(int[] citations) {
        int res = 0;
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            res = Math.max(res,Math.min(citations.length-i,citations[i]));
        }
        return res;
    }
}
