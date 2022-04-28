package com.qx.day21.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: xuan
 * Date: 2021/10/22
 * Time: 14:41
 */
public class No229 {

    public static void main(String[] args) {
        No229 no229 = new No229();
        int[] nums = {1,1,1,3,3,3,2,2,2};
        System.out.println(no229.majorityElement(nums));
    }
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int s = nums.length/3+1;
        for (Map.Entry<Integer,Integer> a:map.entrySet()){
            if(a.getValue()>=s){
                list.add(a.getKey());
            }
        }
        return list;
    }
}
