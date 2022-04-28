package com.qx.day22;

/**
 * @author Xuan
 * Date: 2022/3/18
 * Time: 20:13
 */
public class GaoStudent extends Student {

    public GaoStudent() {
    }

    public GaoStudent(String name, int age) {
        super(name, age);
    }

    @Override
    void study() {
        System.out.println(name);
    }

    void eat(){
        System.out.println(name+"在吃饭");
    }
}
