package com.qx.day24.futuretest;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest2 {
    public static void main(String[] args) throws Exception {
        // 第一个任务:
        CompletableFuture<String> cfQuery = CompletableFuture.supplyAsync(() -> {
            System.out.println(1);
            return queryCode("中国石油");
        });
        // cfQuery成功后继续执行下一个任务:
        CompletableFuture<Double> cfFetch = cfQuery.thenApplyAsync((code)->{
            System.out.println(3);
            return fetchPrice(code);
        } );
        // cfFetch成功后打印结果:
        cfFetch.thenAccept((result) -> {
            System.out.println(5);
            System.out.println("price: " + result);
        });
        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        Thread.sleep(2000);
    }

    static String queryCode(String name) {
        try {
            Thread.sleep(100);
            System.out.println(2);
        } catch (InterruptedException e) {
        }
        return "601857";
    }

    static Double fetchPrice(String code) {
        try {
            Thread.sleep(100);
            System.out.println(4);
        } catch (InterruptedException e) {
        }
        return 5 + Math.random() * 20;
    }
}
