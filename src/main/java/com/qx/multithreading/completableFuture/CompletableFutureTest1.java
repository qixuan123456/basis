package com.qx.multithreading.completableFuture;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest1 {
    public static void main(String[] args) throws Exception {
        // 创建异步执行任务:
        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(CompletableFutureTest1::fetchPrice);
        // 如果执行成功:
        cf.thenAccept((result) -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("price: " + result);
        });
        // 如果执行异常:
        cf.exceptionally((e) -> {
            e.printStackTrace();
            return null;
        });
        System.out.println(Thread.currentThread().getName());
        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        System.out.println("sa");
        Thread.sleep(200);
    }
    public static Double fetchPrice() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        if (Math.random() < 0.1) {
            throw new RuntimeException("fetch price failed!");
        }
        return 5 + Math.random() * 20;
    }
}
