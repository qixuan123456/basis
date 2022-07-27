package com.qx.lock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xuan
 * @date 2022/7/1 20:07
 */
public class ReentrantLockTest {

    public static void main(String[] args) throws Exception{
        ReentrantLock lock = new ReentrantLock();
        AtomicInteger integer1 = new AtomicInteger(1);
        AtomicInteger integer2 = new AtomicInteger(1);
        integer1.compareAndSet(1,2);
        integer2.compareAndSet(1,3);

        Thread a = new Thread(()->{
            System.out.println("进入A线程");
            System.out.println("A线程阻塞");
            LockSupport.park(Thread.currentThread());
            System.out.println("A线程结束");
        },"A");
        a.start();
        Thread.sleep(5000);
        a.interrupt();
    }
}
