package com.qx.shuati.leetcode;

import java.util.PriorityQueue;

/**
 * @author xuan
 * @date 2022/5/28 14:34
 */
public class No1354 {

    public static void main(String[] args) {
        System.out.println(isPossible(new int[]{3,5,9}));
    }

    public static boolean isPossible(int[] target) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->b-a);
        int sum = 0;
        for (int j : target) {
            queue.add(j);
            sum+=j;
        }
        while(!queue.isEmpty()){
            int poll = queue.poll();
            if(poll>1){
                if(sum<=poll){
                    return false;
                }
                int c = (poll-1)/(sum-poll);
                if(c==0){
                    return false;
                }
                int b = poll-c*(sum-poll);
                if(b<1){
                    return false;
                }
                sum = poll-(c-1)*(sum-poll);
                queue.add(b);
            }
        }


        return true;
    }
}
