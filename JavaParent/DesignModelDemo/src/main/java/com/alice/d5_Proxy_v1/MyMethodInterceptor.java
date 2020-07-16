package com.alice.d5_Proxy_v1;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

        long startTime = System.currentTimeMillis();
        // 被代理的对象 tank
        Object result = null;
        result = methodProxy.invokeSuper(obj, args);

        System.out.println("运行时间 " + (System.currentTimeMillis() - startTime) + " ms");
        return result;

//        System.out.println(obj.getClass().getSuperclass().getName());
//        System.out.println("before");
//        Object result = null;
//        result = methodProxy.invokeSuper(obj, args);
//        System.out.println("after");
//        return result;
    }
}
