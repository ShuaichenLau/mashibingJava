package com.alice.d1Singleton;

/**
 * 懒汉式 单例模式
 * 2020-7-7 14:41:18
 *
 * @author liusc
 */
public class Singleton02 {

    private static volatile Singleton02 singleton02;

    private Singleton02() {
    }

    public static Singleton02 getInstance() {
        if (singleton02 == null) {
            synchronized (Singleton02.class) {
                if (singleton02 == null) {
                    singleton02 = new Singleton02();
                }
            }
        }
        return singleton02;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Singleton02.getInstance().toString());
                }
            }).start();
        }
    }
}
