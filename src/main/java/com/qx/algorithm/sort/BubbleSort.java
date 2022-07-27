package com.qx.algorithm.sort;

import java.util.Arrays;

/**
 * @author xuan
 * @date 2022/6/30 15:37
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = new int[]{9,4};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void sort(int[] nums){
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < nums.length-i; j++) {
                if(nums[j]>nums[j+1]){
                    int a = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = a;
                }
            }
        }
    }
}
