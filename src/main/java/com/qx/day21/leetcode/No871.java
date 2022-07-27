package com.qx.day21.leetcode;

import java.util.PriorityQueue;

/**
 * @author xuan
 * @date 2022/7/2 13:29
 */
public class No871 {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if(target<=startFuel){
            return 0;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->b-a);
        int ans = 0;
        for (int i = 0; i < stations.length; i++) {
            while(startFuel<stations[i][0]){
                if(queue.isEmpty()){
                    return -1;
                }else {
                    startFuel+=queue.poll();
                    ans++;
                }
            }
            queue.add(stations[i][1]);
        }

        while(startFuel<target){
            if(queue.isEmpty()){
                return -1;
            }else {
                startFuel+=queue.poll();
                ans++;
            }
        }
        return ans;
    }
}
