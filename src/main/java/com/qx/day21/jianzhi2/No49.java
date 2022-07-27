package com.qx.day21.jianzhi2;

import java.io.Serializable;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author xuan
 * @date 2022/7/5 20:04
 */
public class No49 {

    public int nthUglyNumber(int n) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        int poll = 0;
        queue.add(1);
        set.add(1);
        while (n-->0){
            poll = queue.poll();
            if(set.add(poll*2)){
                queue.add(poll*2);
            }
            if(set.add(poll*3)){
                queue.add(poll*3);
            }
            if(set.add(poll*5)){
                queue.add(poll*5);
            }
        }
        return poll;
    }
}
