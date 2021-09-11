package day21.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No146 {
    public static void main(String[] args) {
        LRUCache l = new LRUCache(2);
        System.out.println(l.get(2));
        l.put(2,6);
        System.out.println(l.get(1));
        l.put(1,5);
        l.put(1,2);
        System.out.println(l.get(1));
        System.out.println(l.get(2));
    }

}
class LRUCache {
    private Map<Integer,Integer> map;
    private List<Integer> list;
    private int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        this.list = new ArrayList<>(capacity);
    }

    public int get(int key) {
        if(map.containsKey(key)){
            list.remove(new Integer(key));
            list.add(key);
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if(list.size()==capacity){
            if(!list.contains(key)){
                map.remove(list.get(0));
                list.remove(0);
            }
        }
        list.remove(new Integer(key));
        list.add(key);
        map.put(key,value);
    }
}