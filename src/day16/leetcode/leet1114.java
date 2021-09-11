package day16.leetcode;

import java.util.concurrent.atomic.AtomicInteger;

public class leet1114 {

        //AtomicInteger
        public static void main(String[] args) {
            AtomicInteger a = new AtomicInteger(0);
            System.out.println(a);
            a.incrementAndGet();
            System.out.println(a);
        }
}
