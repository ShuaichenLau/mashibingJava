package com.alice.d5_Proxy;

import cn.hutool.core.util.RandomUtil;

public class Tank implements Movable {

    @Override
    public void move() {
        System.out.println("tank move .....");
        try {
            Thread.sleep(RandomUtil.randomInt(100, 500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


