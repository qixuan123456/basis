package com.qx.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author xuan
 * @date 2022/7/7 21:28
 */
public class ProxyClass implements InvocationHandler {

    public User user;

    public ProxyClass(User user){
        this.user = user;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("----------");
        method.invoke(user,args);
        return null;
    }
}
