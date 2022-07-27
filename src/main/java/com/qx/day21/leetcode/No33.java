package com.qx.day21.leetcode;

/**
 * @author xuan
 * @date 2022/6/2 11:05
 */
public class No33 {
    public static void main(String[] args) {
        System.out.println(search(new int[]{4,5,6,7,0,1,2},0));
    }
    public static int search(int[] nums, int target) {
        int left = 0,right = nums.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]>=nums[left]){
                if(nums[mid]==target){
                    return mid;
                }else if(nums[mid]<target){
                    left = mid+1;
                }else{
                    if(nums[left]<=target){
                        right = mid-1;
                    }else{
                        left = mid+1;
                    }
                }
            }else{
                if(nums[mid] == target){
                    return mid;
                }else if(nums[mid]<target){
                    if(target<=nums[right]){
                        left = mid+1;
                    }else{
                        right = mid -1;
                    }
                }else{
                    right = mid-1;
                }
            }
        }
        return -1;
    }
}
