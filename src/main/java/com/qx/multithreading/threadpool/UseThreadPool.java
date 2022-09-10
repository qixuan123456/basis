package com.qx.multithreading.threadpool;

import java.util.concurrent.*;

/**
 * @author xuan
 * @date 2022/8/16 21:46
 */
public class UseThreadPool {

    public static void main(String[] args) {
        UseThreadPool useThreadPool = new UseThreadPool();
        ScheduledThreadPoolExecutor service = new ScheduledThreadPoolExecutor(3);
        //ScheduledExecutorService service = Executors.newScheduledThreadPool(3);
        service.scheduleAtFixedRate(useThreadPool::print1,1,1, TimeUnit.SECONDS);
        service.scheduleAtFixedRate(useThreadPool::print2,1,1, TimeUnit.SECONDS);
        service.scheduleAtFixedRate(useThreadPool::print3,1,1, TimeUnit.SECONDS);
    }

    public  void print1() {
        System.out.println(Thread.currentThread().getName() + "  1");
    }
    public  void print2() {
        System.out.println(Thread.currentThread().getName() + "  2");
    }
    public void print3() {
        System.out.println(Thread.currentThread().getName() + "  3");
    }
}
