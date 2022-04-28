package com.qx.day21.leetcode;

import java.util.HashMap;
import java.util.Map;

public class No2001 {
    public static void main(String[] args) {
        int[][] rectangles = {
                {4,8},
                {3,6},
                {1,2},
                {15,30}
        };
        System.out.println(interchangeableRectangles(rectangles));

    }

    public static long interchangeableRectangles(int[][] rectangles) {
        Map<Double,Long> map = new HashMap<>();
        for (int[] rectangle : rectangles) {
            double b = (double) rectangle[0] / (double) rectangle[1];
            if (map.containsKey(b)) {
                map.put(b, map.get(b) + 1L);
            } else {
                map.put(b, 1L);
            }
        }
        long res = 0;
        for (Map.Entry<Double,Long> m:map.entrySet()){
            res += m.getValue()*(m.getValue()-1)/2;
        }
        return res;
    }
}
