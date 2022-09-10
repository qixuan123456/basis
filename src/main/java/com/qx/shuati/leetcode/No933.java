package com.qx.shuati.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class No933 {
    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();

        System.out.println(recentCounter.ping(1));

        System.out.println(recentCounter.ping(1000));

        System.out.println(recentCounter.ping(3001));

        System.out.println(recentCounter.ping(3002));

    }
}
class RecentCounter {
    private Queue<Integer> queue;
    public RecentCounter() {
        this.queue=new LinkedList<>();
    }

    public int ping(int t) {
        this.queue.add(t);
        while(this.queue.peek()+3000<t){
            this.queue.remove();
        }
        return this.queue.size();
    }
}