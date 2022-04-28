package com.qx.multithreading.lock.synchronizedtest;

import java.util.concurrent.TimeUnit;

/**
 * @author Xuan
 * Date: 2022/3/10
 * Time: 15:25
 */
public class ObjectService {

    public void A(){
        synchronized (this){
            for (int i = 0; i < 5; i++) {
                System.out.println("AAAAAAAAAAAA");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    public  void B(){
        for (int i = 0; i < 5; i++) {
            System.out.println("BBBBBBBBBBBB");
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
}
