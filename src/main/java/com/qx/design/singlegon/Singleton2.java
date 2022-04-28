package com.qx.design.singlegon;

/**
 * @author xuan
 * @date 2022/4/22 13:20
 */
public class Singleton2 {

    public static volatile Singleton2 instance;

    public static Singleton2 getInstance() {
        if (instance != null) {
            return instance;
        }
        synchronized (Singleton2.class) {
            if (instance == null) {
                instance = new Singleton2();
            }
            return instance;
        }

    }
}
