package day21.leetcode;

import java.util.Arrays;

/**
 * User: xuan
 * Date: 2021/10/1
 * Time: 19:29
 */
public class No1877 {
    public static void main(String[] args) {
        int[] nums = {3,5,4,2,4,6};
        System.out.println(minPairSum(nums));
    }

    public static int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        int len = nums.length;
        for (int i = 0; i < len / 2; i++) {
            max = Math.max(max,nums[i]+nums[len-i-1]);
        }
        return max;
    }
}
