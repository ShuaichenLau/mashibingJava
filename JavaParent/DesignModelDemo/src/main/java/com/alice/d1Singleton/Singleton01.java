package com.alice.d1Singleton;

/**
 * 饿汉式 单例模式
 *
 * @author liusc
 * 2020-7-7 14:38:41
 */
public class Singleton01 {

    private static Singleton01 singleton01 = new Singleton01();

    private Singleton01() {
    }

    public static Singleton01 getSingleton01() {
        return singleton01;
    }

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    System.out.println(Singleton01.getSingleton01().toString());
                }
            }
        }).start();
    }
}
