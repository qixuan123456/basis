package com.qx.shuati.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: xuan
 * Date: 2021/10/11
 * Time: 13:58
 */
public class No1282 {
    public static void main(String[] args) {
        int[] groupSizes = {2,1,3,3,3,2};
        No1282 no1282 = new No1282();
        System.out.println(no1282.groupThePeople(groupSizes));
    }

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> lists = new ArrayList<>();
        Map<Integer,List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            List<Integer> a= map.getOrDefault(groupSizes[i],new ArrayList<>());
            a.add(i);
            if(a.size()==groupSizes[i]){
                lists.add(new ArrayList<>(a));
                a.clear();
            }
            map.put(groupSizes[i],a);
        }
        return lists;
    }
}
