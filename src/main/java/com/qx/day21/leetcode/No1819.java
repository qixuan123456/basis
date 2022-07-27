package com.qx.day21.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xuan
 * @date 2022/7/14 21:14
 */
public class No1819 {
    public static void main(String[] args) {
        System.out.println(countDifferentSubsequenceGCDs(new int[]{5,15,40,5,6}));
    }
    public static int countDifferentSubsequenceGCDs(int[] nums) {
        int[] ints = new int[2*100000];
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            set.add(a);
            double d = Math.sqrt(a);
            for (int j = 1; j <= d; j++) {
                int c = a%j;
                if(c==0){
                    ints[a/j-1]++;
                    if(ints[a/j-1]>1){
                        break;
                    }
                }
            }
            for (int j = (int)d; j >= 1; j--) {
                int c = a%j;
                if(c==0){
                    ints[j-1]++;
                    if(ints[j-1]>1){
                        break;
                    }
                }
            }

        }

        for (int i = 0; i < ints.length; i++) {
            if(ints[i]>1){
                set.add(i+1);
            }
        }
        return set.size();
    }

}
