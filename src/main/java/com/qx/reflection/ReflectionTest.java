package com.qx.reflection;

import java.lang.reflect.Constructor;

/**
 * @author xuan
 * @date 2022/7/7 20:55
 */
public class ReflectionTest {

    public static void main(String[] args) throws Exception {
        // new
        Test1 test1 = new Test1();
        System.out.println(test1);
        //clazz.newInstance()
        Test1 test2 = Test1.class.newInstance();
        System.out.println(test2);
        //constructor
        Class c = Class.forName("");
        Constructor<Test1> constructor = Test1.class.getConstructor();
        Test1 test3 = constructor.newInstance();
        System.out.println(test3);
    }
}
