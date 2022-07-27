package com.qx.day17.thead.pool;

import java.util.concurrent.*;

/**
 * @author xuan
 * @date 2022/4/28 21:23
 */
public class ThreadPoolExecutorTest {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(3, 5, 1000, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(100), new ThreadPoolExecutor.DiscardPolicy());
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            threadPoolExecutor.submit(new ThreadPoolExecutorTest()::print);
            threadPoolExecutor.submit(()->{
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"   " + finalI);
            });
        }
        Thread.sleep(1000);
        threadPoolExecutor.shutdown();
    }

    public void print(){
        System.out.println("www");
    }
}
