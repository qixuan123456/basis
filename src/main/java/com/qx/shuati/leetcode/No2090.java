package com.qx.shuati.leetcode;

import java.util.Arrays;

/**
 * @author Xuan
 * Date: 2021/11/29
 * Time: 15:21
 */
public class No2090 {

    public static void main(String[] args) {
        int[] nums = {7,4,3,9,1,8,5,2,6};
        int k = 3;
        No2090 no2019 = new No2090();
        System.out.println(Arrays.toString(no2019.getAverages(nums,k)));
    }

    public int[] getAverages(int[] nums, int k) {

        int[] res = new int[nums.length];
        long sum = 0L;
        for(int i=0;i<k*2;i++){
            sum+=nums[i];
        }
        for(int i=0;i<nums.length;i++){
            if(i<k||i+k>nums.length-1){
                res[i]=-1;
                continue;
            }
            sum +=nums[i+k];
            res[i] = (int)sum/(2*k+1);
            sum -= nums[i-k];
        }

        return res;
    }
}
