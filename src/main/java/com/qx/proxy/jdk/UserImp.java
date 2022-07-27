package com.qx.proxy.jdk;

/**
 * @author xuan
 * @date 2022/7/7 21:24
 */
public class UserImp implements User{
    @Override
    public void study(int time) {
        System.out.println("学习了"+time+"分钟");
        System.out.printf("学习了%d分钟%n",time);
    }

    @Override
    public void sleep(int start, int end) throws Throwable {
        System.out.println("从"+start+"点睡到"+end+"点");
    }
}
