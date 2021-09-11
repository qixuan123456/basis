package day21.leetcode;

import java.util.Arrays;

public class No1838 {
    public static void main(String[] args) {
        int[] nums = new int[100000];
        int k = 100000;
        nums[nums.length-1]=1;
        System.out.println(maxFrequency(nums,k));
    }
    public static int maxFrequency(int[] nums, int k) {
        int max = 1;
        int left = 0;
        int right = 0;

        Arrays.sort(nums);
        int sum = nums[0];
        while(left<nums.length&&right<nums.length){
            if((sum+k)/(right-left+1)>=nums[right]){
                max = Math.max(max,right-left+1);
                right++;
                if(right==nums.length){
                    max = Math.max(max,right-left);break;
                }
                sum += nums[right];
            }else {
                sum -= nums[left];
                left++;
            }
        }
        return max;
    }
}
