package com.qx.design.producerconsumer;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Xuan
 * Date: 2022/1/24
 * Time: 16:41
 */
public class ProducerConsumerTest {
    public static void main(String[] args) {
        ProducerConsumer<String> producerConsumer = new ProducerConsumer<>(new LinkedBlockingQueue<>(10000), "main/java/test");
        new Thread(producerConsumer::producer, "生产者线程").start();
        producerConsumer.consumer();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
