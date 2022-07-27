package com.qx.day21.leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author xuan
 * @date 2022/5/28 18:51
 */
public class No1658 {


    public static void main(String[] args) {
        int[] nums = new int[]{1,1};
        int x= 3;
        No1658 no1658 = new No1658();

        System.out.println(no1658.minOperations(nums,x));
    }
    public int minOperations(int[] nums, int x) {
        int target = Arrays.stream(nums).sum() - x;
        if(x <= 0||target<0){
            return 0;
        }
        if(target==0){
            return nums.length;
        }
        int left = 0,right = 0;
        int sum = nums[0];
        int ans = -1;
        while(true){
            if(sum<target){
                right++;
                if(right>=nums.length){
                    break;
                }
                sum+=nums[right];
            }else if(sum>target){
                sum-=nums[left++];
            }else {
                ans = Math.max(ans,right-left+1);
                sum-=nums[left];
                left++;
            }
        }
        return ans==-1?ans:nums.length-ans;
    }
}
