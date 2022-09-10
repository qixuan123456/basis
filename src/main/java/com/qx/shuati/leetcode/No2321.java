package com.qx.shuati.leetcode;

import java.util.Arrays;

/**
 * @author xuan
 * @date 2022/8/1 14:58
 */
public class No2321 {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {

        int s1 = Arrays.stream(nums1).sum();
        int s2 = Arrays.stream(nums2).sum();

        int[] nums = new int[nums1.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums2[i]-nums1[i];
        }
        int ans = Math.max(s1,s2);
        int sum = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum+nums[i];
            if(sum<0){
                sum = 0;
            }
            max = Math.max(sum,max);
        }
        ans = Math.max(ans,s1+max);

        sum = 0;
        int min = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum+nums[i];
            if(sum>0){
                sum = 0;
            }
            min = Math.min(sum,min);
        }
        ans = Math.max(ans,s2-min);

        return ans;
    }
}
