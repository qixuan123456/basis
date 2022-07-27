package com.qx.day21.leetcode;

import java.util.*;

/**
 * @author xuan
 * @date 2022/5/26 13:51
 */
public class No699 {

    public static void main(String[] args) {
        Map<int[],Integer> map = new LinkedHashMap<>();
        int[] ints = {1, 2};
        map.put(ints,3);
        map.put(new int[] {1,2},100);
        System.out.println(map.get(ints));
    }

    public List<Integer> fallingSquares(int[][] positions) {
        List<Integer> ans = new ArrayList<>();
        LinkedList<int[]> queue = new LinkedList<>();
        Map<int[],Integer> map = new HashMap<>();
        
        int max = 0;
//        for (int i = 0; i < positions.length; i++) {
//            int temp = 0;
//            for (int j = 0; j < positions[i][1]; j++) {
//                temp = Math.max(temp,map.getOrDefault(positions[i][0]+j,0));
//            }
//            for (int j = 0; j < positions[i][1]; j++) {
//                map.put(positions[i][0]+j,temp+positions[i][1]);
//            }
//            max = Math.max(max,map.get(positions[i][0]));
//            ans.add(max);
//        }
        

        for (int i = 0; i < positions.length; i++) {
            int temp = 0;
            int left = positions[i][0];
            int right = positions[i][1]+positions[i][0]-1;
            for (int[] a : queue) {
                if(right<a[0]||left>a[1]){
                    continue;
                }else {
                    temp = Math.max(temp,map.get(a));
                }
            }
            int[] a = new int[] {left,right};
            map.put(a,temp+positions[i][1]);
            queue.addFirst(a);
            max = Math.max(max,temp+positions[i][1]);
            ans.add(max);
        }
        return ans;
    }
}
