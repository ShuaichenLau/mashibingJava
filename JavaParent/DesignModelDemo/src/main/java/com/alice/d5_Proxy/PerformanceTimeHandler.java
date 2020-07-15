package com.alice.d5_Proxy;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PerformanceTimeHandler implements InvocationHandler {

    private Tank tank;

    private Log log = LogFactory.get(this.getClass());

    public PerformanceTimeHandler(Tank tank) {
        this.tank = tank;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long startTime = System.currentTimeMillis();
        log.info("method start..." + method.getName());
        // 被代理的对象 tank
        method.invoke(tank, args);
        log.info("method end..." + method.getName());
        log.info("function耗时 ==> " + (System.currentTimeMillis() - startTime) + " ms");
        return proxy;
    }
}
