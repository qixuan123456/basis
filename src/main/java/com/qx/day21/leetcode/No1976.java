package com.qx.day21.leetcode;

import java.util.*;

/**
 * @author xuan
 * @date 2022/5/14 20:51
 */
public class No1976 {
    public static void main(String[] args) {

    }
//    public int countPaths(int n, int[][] roads) {
//        Map<Integer, List<Integer>> map = new HashMap<>();
//        for (int i = 0; i < roads.length; i++) {
//            List<Integer> list1 = map.getOrDefault(roads[i][0],new ArrayList<>());
//            list1.add(roads[i][1]);
//            map.put(roads[i][0],list1);
//
//            List<Integer> list2 = map.getOrDefault(roads[i][1],new ArrayList<>());
//            list2.add(roads[i][0]);
//            map.put(roads[i][1],list2);
//        }
//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(0);
//        while(!queue.isEmpty()){
//            int size = queue.size();
//            while (size-->0){
//                int poll = queue.poll();
//                List<Integer> list = map.get(poll);
//            }
//        }
//
//    }
//
//    public void bfs(Map<Integer,Integer> map1,int[][] roads,Map<Integer,Integer> map2){
//
//    }
}
