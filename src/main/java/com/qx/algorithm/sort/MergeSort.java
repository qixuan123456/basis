package com.qx.algorithm.sort;

import java.util.Arrays;

/**
 * @author xuan
 * @date 2022/6/30 15:18
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] nums = new int[]{1,63,4,23,12,4,23,53,634,12,34,123,543,231,34,-1,234,53,2,3,2,4};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums){
        dfs(0,nums.length-1,nums);
    }

    public static void dfs(int left,int right,int[] nums){
        if(left==right){
            return;
        }
        int mid = (left+right)>>1;
        dfs(left,mid,nums);
        dfs(mid+1,right,nums);
        int[] temp = new int[nums.length];

        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }
        int l = left,r = mid+1;

        for (int i = left; i <= right; i++) {
            if(l<=mid&&(r>right||temp[l]<temp[r])){
                nums[i] = temp[l];
                l++;
            }else {
                nums[i] = temp[r];
                r++;
            }
        }
    }
}
