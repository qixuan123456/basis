package com.qx.day21.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * User: xuan
 * Date: 2021/10/15
 * Time: 18:28
 */
public class No295 {
    public static void main(String[] args) {
        No295 no295 = new No295();
        no295.addNum(1);System.out.println(no295.findMedian());
        no295.addNum(7);System.out.println(no295.findMedian());
        no295.addNum(3);System.out.println(no295.findMedian());
        no295.addNum(2);System.out.println(no295.findMedian());
        no295.addNum(6);System.out.println(no295.findMedian());
    }


    public PriorityQueue<Integer> min;
    public PriorityQueue<Integer> max;
    public No295() {
        min = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        max = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
    }

    public void addNum(int num) {
        if(min.isEmpty() ||num<= min.peek()){
            min.add(num);
            if(min.size()>max.size()+1){
                max.add(min.poll());
            }
        }else {
            max.add(num);
            if(min.size()<max.size()){
                min.add(max.poll());
            }
        }
    }

    public double findMedian() {
        if(min.size()>max.size()){
            return min.peek();
        }else {
            return  (max.peek()+min.peek())/2.0;
        }
    }
//    public List<Integer> list;
//    public No295() {
//        list = new ArrayList<>();
//    }
//
//    public void addNum(int num) {
//        if(list.size()==0){
//            list.add(num);
//            return;
//        }
//        for (int i = 0; i < list.size(); i++) {
//            if(num<=list.get(i)){
//                list.add(i,num);
//                return;
//            }
//        }
//        list.add(num);
//    }
//
//    public double findMedian() {
//        int len = list.size();
//        if(len ==1)
//            return list.get(0);
//        return len%2==1?(double)list.get(len/2):(double) (list.get(len/2)+list.get(len/2-1))/2;
//    }
}
