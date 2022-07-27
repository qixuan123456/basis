package com.qx.algorithm.sort;

import java.util.Arrays;

/**
 * @author xuan
 * @date 2022/6/30 15:17
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 63, 4, 23, 12, 4, 23, 53, 634, 12, 34, 123, 543, 231, 34, -1, 234, 53, 2, 3, 2, 4};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums) {
        dfs(0, nums.length - 1, nums);
    }

    public static void dfs(int left, int right, int[] nums) {
        if (left >= right) {
            return;
        }

        int temp = nums[left];

        int l = left, r = right;
        while (l < r) {

            while (l < r && nums[r] >= temp) {
                r--;
            }

            while (l < r && nums[l] <= temp) {
                l++;
            }

            int a = nums[l];
            nums[l] = nums[r];
            nums[r] = a;

        }
        nums[left] = nums[l];
        nums[l] = temp;
        dfs(left, l - 1, nums);
        dfs(l+1 , right, nums);
    }
}
