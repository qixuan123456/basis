package day21.jingsai.no248;

import day21.tool.Util;

public class No1 {
    public static void main(String[] args) {
        int[] nums = {0,2,1,5,3,4};
        Util.printArray(buildArray(nums));
    }
    public static int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }
}
