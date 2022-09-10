package com.qx.shuati.mianshi;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author xuan
 * @date 2022/8/5 09:23
 */
public class No1625 {

    static class LRUCache {

        LinkedHashMap<Integer,Integer> map;
        int capacity;
        public LRUCache(int capacity) {
            this.map = new LinkedHashMap<>();
            this.capacity = capacity;
        }

        public int get(int key) {
            if(map.containsKey(key)){
                int value = map.get(key);
                map.remove(key);
                map.put(key,value);
                return value;
            }else{
                return -1;
            }
        }

        public void put(int key, int value) {
            if(map.size()==capacity){
                if(map.containsKey(key)){
                    map.remove(key);
                }else{
                    int k = map.entrySet().iterator().next().getKey();
                    map.remove(k);
                }

            }else{
                map.remove(key);
            }
            map.put(key,value);
        }
    }
}
