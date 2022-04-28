package com.qx.day21.leetcode;

import java.util.*;

/**
 * @author xuan
 * @date 2022/4/25 19:01
 */
public class No398 {

    public Map<Integer, List<Integer>> map = new HashMap<>();
    public Random random = new Random();
    public No398(int[] nums) {
        for(int i=0;i<nums.length;i++){
            List<Integer> list = map.getOrDefault(nums[i],new ArrayList<>());
            list.add(i);
            map.put(nums[i],list);
        }
    }

    public int pick(int target) {
        return map.get(target).get(random.nextInt(map.get(target).size()));

    }
}
