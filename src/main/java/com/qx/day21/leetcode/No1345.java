package com.qx.day21.leetcode;

import java.util.*;

/**
 * @author Xuan
 * Date: 2022/1/21
 * Time: 15:46
 */
public class No1345 {
    public static void main(String[] args) {
        int[] arr = {100,-23,-23,404,100,23,23,23,3,404};
        System.out.println(minJumps(arr));
    }

    public static int minJumps(int[] arr) {
        Deque<Integer> queue = new ArrayDeque<>();
        int n = arr.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i=0;i<n;i++) {
            List<Integer> list = map.getOrDefault(arr[i],new ArrayList<>());
            list.add(i);
            map.put(arr[i],list);
        }
        int[] flag = new int[n];
        Arrays.fill(flag,Integer.MAX_VALUE);
        flag[0] = 0;
        queue.addLast(0);
        while (!queue.isEmpty()){
            int a = queue.pollFirst();
            if(a==n-1){
                return flag[a];
            }
            if(a-1>=0&&flag[a-1]==Integer.MAX_VALUE){
                queue.addLast(a-1);
                flag[a-1] = flag[a]+1;
            }
            if(a<n&&flag[a+1]==Integer.MAX_VALUE){
                queue.addLast(a+1);
                flag[a+1] = flag[a]+1;
            }
            List<Integer> c = map.getOrDefault(arr[a],new ArrayList<>());
            for (int s : c) {
                if(flag[s]==Integer.MAX_VALUE){
                    queue.addLast(s);
                    flag[s] = flag[a]+1;
                }
            }
            map.remove(arr[a]);
        }
        return -1;

    }
}
