package com.qx.day21.leetcode;



/**
 * @author Xuan
 * Date: 2021/11/10
 * Time: 15:41
 */
public class No495 {
    public static void main(String[] args) {

    }


    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int sum = 0;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            sum += Math.min(timeSeries[i + 1] - timeSeries[i], duration);
        }
        return sum + duration;
    }
}
