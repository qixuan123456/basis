package com.qx.multithreading.lock.synchronizedtest;

/**
 * @author Xuan
 * Date: 2022/3/10
 * Time: 15:21
 */
public class Test {
    public static void main(String[] args) {
        ObjectService objectService = new ObjectService();
        SyncThread s1 = new SyncThread(objectService);
        SyncThread s2 = new SyncThread(objectService);
        Thread A = new Thread(s1,"A");
        Thread B = new Thread(s2,"B");
        A.start();
        B.start();


    }
}
