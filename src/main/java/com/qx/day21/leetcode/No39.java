package com.qx.day21.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * User: xuan
 * Date: 2021/9/29
 * Time: 10:42
 */
public class No39 {

    public static void main(String[] args) {
        int[] candidates = {2,3,5};
        int target = 8;
        System.out.println(combinationSum(candidates,target));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        combination(candidates,target,lists,new ArrayList<Integer>(),0);
        return lists;
    }

    private static void combination(int[] candidates ,int target,List<List<Integer>> lists,List<Integer> list ,int a) {
        if(target<0||a>= candidates.length){
            return;
        }
        if(target==0){
            lists.add(new ArrayList<>(list));
            return;
        }
        list.add(candidates[a]);
        combination(candidates,target-candidates[a],lists,list,a);
        list.remove(list.size()-1);
        combination(candidates,target,lists,list,a+1);

    }
}
