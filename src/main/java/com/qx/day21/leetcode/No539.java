package com.qx.day21.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * @author Xuan
 * Date: 2022/1/18
 * Time: 19:09
 */
public class No539 {
    public static void main(String[] args) {
        List<String> timePoints = Arrays.asList("00:00","23:59","00:00");
        No539 no539 = new No539();
        System.out.println(no539.findMinDifference(timePoints));
    }
    public int findMinDifference(List<String> timePoints) {
        int size = timePoints.size();
        int[] nums = new int[size];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            nums[i] = transform(timePoints.get(i));
        }
        Arrays.sort(nums);

        for (int i = 1; i < size; i++) {
            min = Math.min(min, (nums[i] - nums[i - 1]));
        }
        min = Math.min(min,nums[0]+24*60-nums[size-1]);
        return min;
    }
    public int transform(String s){
        String[] ss = s.split(":");
        return Integer.parseInt(ss[0])*60+Integer.parseInt(ss[1]);
    }
}
