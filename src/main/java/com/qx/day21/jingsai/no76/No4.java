package com.qx.day21.jingsai.no76;

import java.util.*;

/**
 * @author xuan
 * @date 2022/4/21 20:48
 */
public class No4 {

    public static void main(String[] args) {
        int[] scores = {5,2,9,8,4};
        int[][] edges = {{0,1},{1,2},{2,3},{0,2},{1,3},{2,4}};
        System.out.println(new No4().maximumScore(scores, edges));
    }
    public int ans = -1;
    public int maximumScore(int[] scores, int[][] edges) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        boolean[] flag = new boolean[scores.length];
        for (int i = 0; i < edges.length; i++) {
            Set<Integer> set0 = map.getOrDefault(edges[i][0],new HashSet<>());
            Set<Integer> set1 = map.getOrDefault(edges[i][1],new HashSet<>());
            set0.add(edges[i][1]);
            set1.add(edges[i][0]);
            map.put(edges[i][0],set0);
            map.put(edges[i][1],set1);
        }

        for (int i = 0; i < scores.length; i++) {

            dfs(map,scores,i,1,flag,scores[i]);


        }
        return ans;
    }
    public void dfs(Map<Integer, Set<Integer>> map,int[] scores,int count,int length,boolean[] flag,int sum){
        if(length==4){
            ans = Math.max(sum,ans);
            return;
        }
        if(!flag[count]){
            Set<Integer> set = map.get(count);
            if(set==null){
                return;
            }
            for (Integer i:set) {
                if(!flag[i]){
                    flag[count] = true;
                    dfs(map,scores,i,length+1,flag,sum+scores[i]);
                    flag[count] = false;
                }
            }
        }
    }
}
