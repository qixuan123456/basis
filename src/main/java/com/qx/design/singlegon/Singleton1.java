package com.qx.design.singlegon;

/**
 * @author xuan
 * @date 2022/4/22 13:17
 */
public class Singleton1 {
    public static Singleton1 instance;

    public static Singleton1 getInstance(){
        if(instance==null){
            instance = new Singleton1();
        }
        return instance;
    }
}
