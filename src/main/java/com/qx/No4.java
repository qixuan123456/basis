package com.qx;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author xuan
 * @date 2022/7/8 14:38
 */
public class No4 {

    public static void main(String[] args) {
        System.out.println(minTransfers(new int[][]{{0, 1, 5}, {2, 3, 1}, {2, 0, 1}, {4, 0, 2}}));
    }

    public static int minTransfers(int[][] distributions) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < distributions.length; i++) {
            map.put(distributions[i][0],map.getOrDefault(distributions[i][0],0)-distributions[i][2]);
            map.put(distributions[i][1],map.getOrDefault(distributions[i][1],0)+distributions[i][2]);
        }

        Map<Integer,Integer> map1 = new HashMap<>();
        int ans = 0;

        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if(entry.getValue()<0){
                map1.put(entry.getValue(),map1.getOrDefault(entry.getValue(),0)+1);
            }
        }
        PriorityQueue<Integer> big = new PriorityQueue<>((a,b)->b-a);
        PriorityQueue<Integer> small = new PriorityQueue<>();
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if(entry.getValue()>0){
                if(map1.containsKey(-entry.getValue())&&map1.get(-entry.getValue())>0){
                    map1.put(-entry.getValue(),map1.get(-entry.getValue())-1);
                    ans++;
                }else {
                    big.add(entry.getValue());
                }
            }
        }
        for (Map.Entry<Integer,Integer> entry : map1.entrySet()) {
            if(entry.getKey()<0){
                for (int i = 0; i < entry.getValue(); i++) {
                    small.add(entry.getKey());
                }
            }
        }
        while (!big.isEmpty()&&!small.isEmpty()){
            int h = big.poll()+small.poll();
            if(h>0){
                big.add(h);
            }
            if (h<0){
                small.add(h);
            }
            ans++;
        }
        return ans;
    }
}
