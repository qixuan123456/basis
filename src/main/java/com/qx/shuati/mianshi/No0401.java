package com.qx.shuati.mianshi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xuan
 * @date 2022/6/23 20:29
 */
public class No0401 {

    Map<Integer, List<Integer>> map = new HashMap<>();
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {

        for (int i = 0; i < graph.length; i++) {
            List<Integer> orDefault = map.getOrDefault(graph[i][0], new ArrayList<>());
            orDefault.add(graph[i][1]);
            map.put(graph[i][0],orDefault);
        }
        return dfs(start,target,new boolean[n]);
    }

    public boolean dfs(int start,int target,boolean[] flag){
        if(flag[start]){
            return false;
        }
        if(start==target){
            return true;
        }
        flag[start] = true;
        List<Integer> list = map.get(start);
        if(list==null){
            return false;
        }

        for (Integer i : list) {
            if(dfs(i,target,flag)){
                return true;
            }
        }
        return false;
    }
}
