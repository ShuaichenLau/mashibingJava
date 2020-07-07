package com.alice.d1Singleton;

/**
 * 枚举类实现
 * 2020-7-7 20:06:18
 *
 * @author liusc
 */
public class Singleton04 {

    private Singleton04() {
    }

    private enum Singleton04Enum {
        INSTANCE;
        private final Singleton04 instance;

        Singleton04Enum() {
            instance = new Singleton04();
        }

        private Singleton04 getInstance() {
            return instance;
        }

    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Singleton04Enum.INSTANCE.getInstance());
                }
            }).start();
        }
    }
}
