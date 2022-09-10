package com.qx.shuati.leetcode;

public class No198 {
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        System.out.println(rob(nums));
    }
    public static int rob(int[] nums) {
        if(nums.length==1)
            return nums[0];
        int[] a = new int[nums.length];
        a[0] = nums[0];
        for (int i = 1; i < a.length; i++) {
            if(i==1){
                a[1] = Math.max(nums[0],nums[1]);
                continue;
            }
            a[i] = Math.max(a[i-1],a[i-2]+nums[i]);

        }
        return Math.max(a[a.length-1],a[a.length-2]);
    }
}
