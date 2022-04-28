package com.qx.day21.leetcode;


import com.qx.day21.tool.Util;

public class No283 {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        Util.printArray(nums);
        moveZeroes(nums);
        Util.printArray(nums);
    }
    public static void moveZeroes(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0){
                continue;
            }

            for (int j = i+1; j < nums.length; j++) {
                if(nums[j]!=0){
                    int a= nums[i];
                    nums[i]=nums[j];
                    nums[j]=a;break;
                }
            }
        }
    }
}
