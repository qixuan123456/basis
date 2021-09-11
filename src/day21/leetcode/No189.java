package day21.leetcode;

import day21.tool.Util;

public class No189 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotate(nums,k);
        Util.printArray(nums);
    }

    public static void rotate(int[] nums, int k) {
        int[] target = new int[k% nums.length];
        System.arraycopy(nums,nums.length-k%nums.length,target,0,target.length);
        System.arraycopy(nums,0,nums,k%nums.length,nums.length-k%nums.length);
        System.arraycopy(target, 0, nums, 0, target.length);
    }
}
