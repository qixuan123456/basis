package com.qx.zhenti.tencent.music.shixi2022;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @author xuan
 * @date 2022/6/17 13:39
 */
public class No2 {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(7);
        a.add(2);
        a.add(1);
        System.out.println(minMax(a,3,3));
    }

    public static int minMax (ArrayList<Integer> a, int k, int x) {
        // write code here

        PriorityQueue<Integer> queue = new PriorityQueue<>((b,c)->c-b);
        queue.addAll(a);
        for (int i = 0; i < k; i++) {
            queue.add(queue.poll()-x);
        }
        return queue.poll();
    }
}
