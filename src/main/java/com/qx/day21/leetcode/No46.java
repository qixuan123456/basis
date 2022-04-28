package com.qx.day21.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * User: xuan
 * Date: 2021/10/11
 * Time: 14:29
 */
public class No46 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        No46 no46 = new No46();
        System.out.println(no46.permute(nums));
    }
    public List<List<Integer>> permute(int[] nums) {
        boolean[] flag = new boolean[nums.length];
        List<List<Integer>> lists = new ArrayList<>();
        permute(nums,flag,lists,new ArrayList<>());
        return lists;
    }

    public void permute(int[] nums,boolean[] flag,List<List<Integer>> lists, ArrayList<Integer> list){
        if(list.size()==nums.length){
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(!flag[i]){
                list.add(nums[i]);
                flag[i] = true;
                permute(nums,flag,lists,list);
                list.remove(new Integer(nums[i]));
                flag[i] = false;
            }
        }
    }
}
