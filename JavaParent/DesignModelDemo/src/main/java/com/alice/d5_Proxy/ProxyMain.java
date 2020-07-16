package com.alice.d5_Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 *
 * @author liusc
 * 2020-7-15 15:26:18
 */
public class ProxyMain {

    public static void main(String[] args) {
        Tank tank = new Tank();
        Movable movable = (Movable) Proxy.newProxyInstance(tank.getClass().getClassLoader(),
                new Class[]{Movable.class},
                new PerformanceTimeHandler(tank));
        movable.move();
    }
}
