package com.qx.shuati.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuan
 * @date 2022/8/10 15:14
 */
public class No2161 {

    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> min = new ArrayList<>();
        List<Integer> mid = new ArrayList<>();
        List<Integer> max = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if(nums[i]<pivot){
                min.add(nums[i]);
            }else if(nums[i]==pivot){
                mid.add(nums[i]);
            }else {
                max.add(nums[i]);
            }

        }

        min.addAll(mid);
        mid.addAll(max);
        return min.stream().mapToInt(Integer::intValue).toArray();
    }
}
