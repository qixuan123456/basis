package com.qx.day21.leetcode;

/**
 * User: xuan
 * Date: 2021/10/3
 * Time: 16:21
 */
public class No334 {
    public static void main(String[] args) {
        int[] nums = {1,2,2,3,4};
        System.out.println(increasingTriplet(nums));
    }
    public static boolean increasingTriplet(int[] nums) {
        int flag = 1;
        for (int i = 1 ; i < nums.length; i++) {
            if(nums[i]>nums[i-1]){
                flag++;
                if(flag==3){
                    return true;
                }
            }else {
                flag=1;
            }
        }
        return false;
    }
}
