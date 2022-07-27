package com.qx.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author xuan
 * @date 2022/7/7 21:34
 */
public class Test {

    public static void main(String[] args) throws Throwable {

        User user = new UserImp();
        InvocationHandler handler = new ProxyClass(user);
        User u = (User) Proxy.newProxyInstance(handler.getClass().getClassLoader(),user.getClass().getInterfaces(),handler);
        u.study(19);
        u.sleep(19,122);
    }
}
