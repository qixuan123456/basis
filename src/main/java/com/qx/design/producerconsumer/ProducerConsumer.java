package com.qx.design.producerconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Xuan
 * Date: 2022/1/24
 * Time: 16:42
 */
public class ProducerConsumer<T> {
    private volatile boolean flag = true;

    private volatile boolean stop = false;

    private final BlockingQueue<String> blockingQueue;

    private final AtomicInteger producerInteger = new AtomicInteger(0);
    private final AtomicInteger consumerInteger = new AtomicInteger(0);

    private final String t;

    public ProducerConsumer(BlockingQueue<String> blockingQueue, String t) {
        this.blockingQueue = blockingQueue;
        this.t = t;
    }

    public void producer() {
        //多线程并发，不能用if判断，避免出现并发异常
        for (int i = 0; i < 10000; i++) {
            try {
                blockingQueue.offer(t+i, 2, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            producerInteger.incrementAndGet();
            //System.out.println(Thread.currentThread().getName() + "生产元素" + t+i + "成功");
        }

        flag = false;
        System.out.println("生产者生产了" + producerInteger.get() + "个元素");
        System.out.println("生产者停止工作");
    }


    public void consumer() {
        long start = System.currentTimeMillis();
        while (flag||!blockingQueue.isEmpty()) {
            //队列里面没有元素，默认返回null
            String take = null;
            try {
                take = blockingQueue.poll(2, TimeUnit.SECONDS);
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (null != take) {
                consumerInteger.incrementAndGet();
                //System.out.println("消费者取出的元素为：" + take);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("消费者消费了" + consumerInteger.get() + "个元素");
        System.out.println("消费者停止工作");
        System.out.println("花费"+(end-start)+"ms");

    }

    public void stop() {
        stop = true;
    }
}
