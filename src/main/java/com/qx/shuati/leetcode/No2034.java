package com.qx.shuati.leetcode;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * User: xuan
 * Date: 2021/10/12
 * Time: 20:31
 */
public class No2034 {

    public static void main(String[] args) {

        No2034 no2034 = new No2034();
        no2034.update(1,2);
        no2034.update(3,1);
        no2034.update(5,6);
        no2034.update(2,3);
    }

    TreeMap<Integer,Integer> map = new TreeMap<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    });
    int[] current = new int[2];
    public No2034() {

    }

    public void update(int timestamp, int price) {
        map.put(timestamp,price);
        if(timestamp>=current[0]){
            current[0] = timestamp;
            current[1] = price;
        }
    }

    public int current() {
        return 0;
    }

    public int maximum() {
        return 0;
    }

    public int minimum() {
        return 0;
    }
}
