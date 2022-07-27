package com.qx.day21.leetcode;

import java.util.*;

public class No146 {
    public static void main(String[] args) {
        LRUCache l = new LRUCache(2);

        l.put(1,1);
        l.put(2,2);
        System.out.println(l.get(1));
        l.put(3,3);
        System.out.println(l.get(2));
        l.put(4,4);

        System.out.println(l.get(1));
        System.out.println(l.get(3));
        System.out.println(l.get(4));
    }

}
class LRUCache {
    private final Map<Integer,Integer> map;
    private final Queue<Integer> queue;
    private final int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        this.queue = new LinkedList<>();
    }

    public int get(int key) {
        if(map.containsKey(key)){
            queue.remove(key);
            queue.add(key);
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if(queue.size()>=capacity){
            if(map.containsKey(key)){
                queue.remove(key);
                queue.add(key);
            }else {
                map.remove(queue.poll());
                queue.add(key);
            }
        }else {
            if(map.containsKey(key)){
                queue.remove(key);
                queue.add(key);
            }else {
                queue.add(key);
            }
        }
        map.put(key,value);
    }
}