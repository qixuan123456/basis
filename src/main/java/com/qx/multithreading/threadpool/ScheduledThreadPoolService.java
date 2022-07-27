package com.qx.multithreading.threadpool;

import java.sql.Time;
import java.util.Date;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author xuan
 * @date 2022/6/13 18:58
 */
public class ScheduledThreadPoolService {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutor = new ScheduledThreadPoolExecutor(3);

        scheduledExecutor.scheduleAtFixedRate(ScheduledThreadPoolService::balance,10,10, TimeUnit.SECONDS);
        scheduledExecutor.scheduleAtFixedRate(ScheduledThreadPoolService::clean,64,32, TimeUnit.SECONDS);
        scheduledExecutor.scheduleAtFixedRate(ScheduledThreadPoolService::update,64,32, TimeUnit.SECONDS);
    }

    public static void update(){
        System.out.println(new Date()+"更新");
    }

    public static void clean(){
        System.out.println(new Date()+"清理");
    }
    public static void balance(){
        System.out.println(new Date()+"发送余额");
    }
}
