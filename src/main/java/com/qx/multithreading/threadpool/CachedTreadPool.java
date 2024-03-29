package com.qx.multithreading.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * User: Xuan
 * Date: 2021/10/28
 * Time: 15:17
 */
public class CachedTreadPool {
    public static void main(String[] args) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for(int i = 0;i<10;i++){
            final int index = i;
            try {
                Thread.sleep(index*1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            cachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+" "+index);
                }
            });
        }
    }
}
