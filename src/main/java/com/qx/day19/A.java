package com.qx.day19;

import java.lang.ref.SoftReference;

/**
 * @author xuan
 * @date 2022/6/27 19:39
 */
public class A {


    public A(){
        System.out.println("构造方法");
    }

    public static void main(String[] args) {
        A a = new A();

        SoftReference softReference = new SoftReference(a);

        a = null;
        System.gc();


    }
}
