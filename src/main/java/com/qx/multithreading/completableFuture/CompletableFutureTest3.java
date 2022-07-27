package com.qx.multithreading.completableFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class CompletableFutureTest3 {

    public static void main(String[] args) {
        CompletableFutureTest3 test = new CompletableFutureTest3();
        ExecutorService executorService = new ThreadPoolExecutor(20,20,10000, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(10000));
        List<CompletableFuture<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {

            CompletableFuture<Integer> future =  CompletableFuture.supplyAsync(test::qwe,executorService);
            list.add(future);
        }
        System.out.println("任务加入完毕");

        CompletableFuture<Object> re = CompletableFuture.anyOf(list.toArray(new CompletableFuture[]{}));
        re.thenAccept((result)->{
            System.out.println("任务执行完毕"+result);
        });
        executorService.shutdown();
    }

    public Integer qwe() {
        Random random = new Random();
        int r = random.nextInt(100);
        try {

            Thread.sleep(r*1);
            System.out.println(r);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return r;
    }
}
