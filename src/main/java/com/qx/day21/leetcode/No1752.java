package com.qx.day21.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xuan
 * @date 2022/6/21 15:30
 */
public class No1752 {

    public static void main(String[] args) {
        No1752 no1752 = new No1752();
        int[] source = {2,3,1};
        int[] target = {1,2,2};
        int[][] allowedSwaps = {{0,2},{1,2}};
        System.out.println(no1752.minimumHammingDistance(source,target,allowedSwaps));
    }
    int[] weight;
    int[] group;
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        group = new int[source.length];
        weight = new int[source.length];
        for (int i = 0; i < group.length; i++) {
            group[i] = i;
            weight[i] = 1;
        }
        for (int i = 0; i < allowedSwaps.length; i++) {
            union(allowedSwaps[i][0],allowedSwaps[i][1]);
        }
        Map<Integer, Map<Integer,Integer>> map1 = new HashMap<>();
        Map<Integer, Map<Integer,Integer>> map2 = new HashMap<>();
        for (int i = 0; i < group.length; i++) {
            int a = find(i);
            Map<Integer,Integer> mapOrDefault1 = map1.getOrDefault(a,new HashMap<>());
            mapOrDefault1.put(source[i],mapOrDefault1.getOrDefault(source[i],0)+1);
            map1.put(a,mapOrDefault1);

            Map<Integer,Integer> mapOrDefault2 = map2.getOrDefault(a,new HashMap<>());
            mapOrDefault2.put(target[i],mapOrDefault2.getOrDefault(target[i],0)+1);
            map2.put(a,mapOrDefault2);
        }
        int ans = 0;
        for (Map.Entry<Integer, Map<Integer,Integer>> entry : map1.entrySet()) {
            Map<Integer,Integer> list1 = entry.getValue();
            Map<Integer,Integer> list2 = map2.get(entry.getKey());

            if(list1==null||list2==null){
                continue;
            }
            for (Map.Entry<Integer,Integer> e : list1.entrySet()) {
                int a = e.getValue();
                int b = list2.getOrDefault(e.getKey(),0);
                ans+=Math.min(a,b);
            }
        }


        return source.length-ans;
    }
    
    public int find(int index){
        if(group[index]!=index){
            index = find(group[index]);
        }
        return group[index];
    }
    
    public void union(int a,int b){
        a = find(a);
        b = find(b);
        if(weight[a]>weight[b]){
            group[b] = a;
            weight[a] += weight[b];
        }else {
            group[a] = b;
            weight[b] += weight[a];
        }
    }
}
