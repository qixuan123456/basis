package Day21.LeetCode;

import Day21.tool.Util;

public class No1 {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 26;
        Util.printArray(twoSum(nums,target));
    }
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]+nums[j]==target)
                    return new int[]{i,j};
            }
        }
        return null;
    }
}
