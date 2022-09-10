package com.qx.shuati.leetcode;

import java.util.Arrays;

/**
 * @author xuan
 * @date 2022/6/15 19:09
 */
public class No719 {

    public static void main(String[] args) {
        System.out.println(smallestDistancePair(new int[]{62, 100, 4}, 2));
    }

    public static int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0,right = nums[nums.length-1]-nums[0];
        while (left<right){
            int mid = (left+right)>>1;
            int cnt = 0;
            for (int i = 0; i < nums.length; i++) {
                cnt+= (binarySearch(nums,nums[i]+mid,i)-i-1);
            }
            if(cnt>=k){
                right = mid;
            }else {
                left = mid+1;
            }
        }
        return left;
    }

    private static int binarySearch(int[] nums, int i,int start) {

        int left = start,right = nums.length;
        while (left<right){
            int mid = (left+right)>>1;
            if(nums[mid]>i){
                right = mid;
            }else {
                left = mid+1;
            }
        }
        return left;
    }
}
