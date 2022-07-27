package com.qx.day21.leetcode;

import java.util.TreeMap;

/**
 * @author xuan
 * @date 2022/5/13 20:10
 */
public class No493 {


    public static void main(String[] args) {
        int[] nums = {1,3,2,3,1};
        System.out.println(reversePairs(nums));
    }

    public static int reversePairs(int[] nums) {
        TreeMap<long[],Boolean> map = new TreeMap<>((a,b)->{
            if(a[0]==b[0]){
                return  (a[1]-b[1])>0?1:-1;
            }else {
                return  (a[0]-b[0])>0?1:-1;
            }
        });
        int ans = 0;
        for (int i = nums.length-1; i >= 0; i--) {
            ans+=map.headMap(new long[]{ (long) nums[i],(long) i}).size();
            map.put(new long[]{ ((long) nums[i])*2,(long)i },true);
        }
        return ans;
    }
}
