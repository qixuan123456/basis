package com.qx.day21.jianzhi2;

import java.util.Arrays;

/**
 * @author xuan
 * @date 2022/7/4 18:30
 */
public class No45 {

    public String minNumber(int[] nums) {
        Integer[] numsCopy = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsCopy[i] = nums[i];
        }
        Arrays.sort(numsCopy,(a,b) -> (a.toString()+b).compareTo(b.toString()+a));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(numsCopy[i]);
        }
        return sb.toString();
    }


}
