package com.qx.multithreading.threadpool;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Xuan
 * Date: 2021/10/28
 * Time: 15:31
 */
public class ScheduledThreadPool {
    public static void main(String[] args) {
        ScheduledThreadPool scheduledThreadPool = new ScheduledThreadPool();
        scheduledThreadPool.test3();

    }

    /**
     * 延迟3秒执行
     */
    public void test1(){
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        scheduledThreadPool.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("delay 3 seconds");
            }
        },3, TimeUnit.SECONDS);
    }

    /**
     * 延迟2秒每隔三秒执行一次
     */
    public void test2(){
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("延迟1秒，每隔三秒执行一次");
            }
        },1,3,TimeUnit.SECONDS);
    }

    public void test3(){
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(1);
        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("================"+new Date());
            }
        },1,5,TimeUnit.SECONDS);
        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(new Date());
            }
        },1,2,TimeUnit.SECONDS);
    }
}
