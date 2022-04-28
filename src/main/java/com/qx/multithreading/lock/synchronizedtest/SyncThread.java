package com.qx.multithreading.lock.synchronizedtest;

/**
 * @author Xuan
 * Date: 2022/3/10
 * Time: 15:17
 */
public class SyncThread implements Runnable {
    ObjectService objectService;
    public SyncThread(ObjectService objectService){
        this.objectService = objectService;
    }
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        if(name.equals("A")){
            objectService.A();
        }else {
            objectService.B();
        }

    }
}
