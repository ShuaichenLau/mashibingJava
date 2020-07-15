package com.alice.d5_Proxy_v1;

import com.alice.d5_Proxy.PerformanceTimeHandler;
import com.alice.d5_Proxy.Tank;
import net.sf.cglib.proxy.Enhancer;

/**
 * CGLIB 动态代理生成
 */
public class ProxyMainV1 {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Tank.class);
        enhancer.setCallback(new MyMethodInterceptor());
        Tank tank = (Tank) enhancer.create();
        tank.move();

    }
}
