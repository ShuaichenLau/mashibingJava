package com.alice.d1Singleton;

/**
 * 静态内部类
 *
 * @author liusc
 * 2020-7-7 20:02:36
 */
public class Singleton03 {

    private Singleton03() {
    }


    private static class InnerSingletonClass {
        private static final Singleton03 singleton03 = new Singleton03();
    }

    public static Singleton03 getInstance() {
        return InnerSingletonClass.singleton03;
    }


}
