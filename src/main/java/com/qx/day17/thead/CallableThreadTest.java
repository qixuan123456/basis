package com.qx.day17.thead;

import java.util.concurrent.*;

/**
 * @author xuan
 * @date 2022/4/28 20:31
 */
public class CallableThreadTest implements Callable<Integer> {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        CallableThreadTest callable = new CallableThreadTest();
        FutureTask<Integer> future = new FutureTask<>(callable);
        //future只能执行一次，执行以后会修改state和runnerOffset，导致后面的线程不能执行成功，
        //具体实现在源码中有提及
        //异步执行
        for (int i = 0; i < 10; i++) {
            new Thread(future, "MyThread-" + i).start();
        }
        //一步获取执行结果（等待一秒），可能会获取失败，线程未执行完毕。
        System.out.println(future.get(1, TimeUnit.SECONDS));
        System.out.println("qx");
        new Thread(future, "MyThread-" + 2).start();
    }

    @Override
    public Integer call() throws Exception {
        int i = 0;
        Thread.sleep(900);
        for (; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }

        return 1;
    }
}
