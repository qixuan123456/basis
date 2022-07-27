package com.qx.day21.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xuan
 * @date 2022/7/21 14:02
 */
public class No128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for (int num : set) {
            if(!set.contains(num-1)){
                int l = 1;
                int c = num+1;
                while(set.contains(c)){
                    l++;
                    c++;
                }
                ans = Math.max(ans,l);
            }
        }

        return ans;
    }
}
