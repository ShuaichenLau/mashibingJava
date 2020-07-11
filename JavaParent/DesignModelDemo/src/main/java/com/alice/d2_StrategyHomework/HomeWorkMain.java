package com.alice.d2_StrategyHomework;

/**
 * 策略模式:
 * 策略模式应用到 tank fire
 * 策略1:默认策略 打出一个子弹
 * 策略2:打出4个方向子弹
 * 策略3:打出核弹
 *
 * 多态是面向对象的核心
 */
public class HomeWorkMain {
    public static void main(String[] args) {
        // 工厂模式...
        TankParent superTank = new SuperTank();
        superTank.fire();


        TankParent commonTank = new CommonTank();
        commonTank.fire();
    }
}
