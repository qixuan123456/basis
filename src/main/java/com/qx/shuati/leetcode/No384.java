package com.qx.shuati.leetcode;

import com.qx.shuati.tool.Util;

import java.util.Random;

/**
 * @author Xuan
 * Date: 2021/11/22
 * Time: 11:14
 */
public class No384 {
    public static void main(String[] args) {

        Solution solution = new Solution(new int[]{4,2,3});
        Util.printArray(solution.shuffle());
        Util.printArray(solution.reset());
        Util.printArray(solution.shuffle());
    }



    static class Solution {

        int[] nums;
        int[] shuffleNums;
        public Solution(int[] nums) {
            this.nums = nums;
            shuffleNums = new int[nums.length];
            System.arraycopy(nums,0,shuffleNums,0,nums.length);
        }

        public int[] reset() {
            return this.nums;
        }

        public int[] shuffle() {
            Random random = new Random();
            for (int i = 0; i < nums.length; i++) {
                int n = i+random.nextInt(nums.length-i);
                int a = shuffleNums[n];
                shuffleNums[n] = shuffleNums[i];
                shuffleNums[i] = a;
            }

            return this.shuffleNums;
        }
    }
}
