package com.qx.multithreading.threadpool;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author xuan
 * @date 2022/8/1 11:29
 */
public class test {

    private final ScheduledExecutorService scheduledExecutor = new ScheduledThreadPoolExecutor(3, new BasicThreadFactory.Builder()
            .namingPattern("MinerManager-Scheduled-Thread-%d")
            .daemon(true)
            .build());


    public static void main(String[] args) throws InterruptedException {
        test t = new test();
        t.init();

        while (!t.scheduledExecutor.isTerminated()) {
            Thread.sleep(1000);
        }
    }

    int a = 1;

    public void init() {
        scheduledExecutor.scheduleAtFixedRate(this::aaaa, 100, 200, TimeUnit.MILLISECONDS);
    }

    public void aaaa() {
        try{
            if (a != 10) {
                System.out.println(a);
                a++;
            } else {
                throw new RuntimeException();
            }

        }catch (Exception e){
            a++;

            System.out.println(e);
        }

    }
}
