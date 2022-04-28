package com.qx.day21.leetcode;

/**
 * User: xuan
 * Date: 2021/9/26
 * Time: 17:55
 */
public class No213 {
    public static void main(String[] args) {
        int[] nums = {2,3,6};
        System.out.println(rob(nums));
    }


    public static int rob(int[] nums) {
        int len = nums.length;
        if(len<2){
            return nums[0];
        }
        int[] res = new int[len];
        int[] res1 = new int[len];
        res[0] = nums[0];res1[1]=nums[1];
        res[1] = Math.max(nums[0],nums[1]);
        if(nums.length==2){
            return res[1];
        }
        res1[2]= Math.max(nums[1],nums[2]);
        for (int i = 2; i < len-1; i++) {
            res[i] = Math.max(res[i-1],res[i-2]+nums[i]);
        }
        for (int i = 3; i < len; i++) {
            res1[i] = Math.max(res1[i-1],res1[i-2]+nums[i]);
        }
        return Math.max(res[len-2],res1[len-1]);
    }
}
