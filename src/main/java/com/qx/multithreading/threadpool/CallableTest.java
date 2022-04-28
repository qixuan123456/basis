package com.qx.multithreading.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Xuan
 * Date: 2021/10/28
 * Time: 17:03
 */
public class CallableTest {

    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<Integer> future =  executorService.submit(new Task());
        Integer integer = future.get();
        System.out.println(1);
        System.out.println(integer);
        executorService.shutdown();
    }

    static class Task implements Callable<Integer>{
        @Override
        public Integer call() throws Exception {
            System.out.println("子线程运行。。。");
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                sum+=i;
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            return sum;
        }
    }
}

