package com.qx.shuati.jingsai.no247;

import java.util.Arrays;

public class No1 {
    public static void main(String[] args) {
        int[] nums = {5,6,2,7,4};
        System.out.println(maxProductDifference(nums));
    }
    public static int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        return Math.abs(nums[0]*nums[1]-nums[nums.length-1]*nums[nums.length-2]);
    }
}
