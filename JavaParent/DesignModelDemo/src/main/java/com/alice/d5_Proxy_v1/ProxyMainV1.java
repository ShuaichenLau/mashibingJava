package com.alice.d5_Proxy_v1;

import net.sf.cglib.proxy.Enhancer;

import java.util.ArrayList;

/**
 * CGLIB 动态代理生成
 */
public class ProxyMainV1 {
    public static void main(String[] args) {

        ArrayList<Object> objects = new ArrayList<>();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(TankProxy.class);
        enhancer.setCallback(new MyMethodInterceptor());
        TankProxy tank = (TankProxy) enhancer.create();
        tank.move();
    }
}
