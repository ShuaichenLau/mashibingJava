package com.alice.d1_Singleton;

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

        try {
            Class.forName("com.alice.d1_Singleton.Singleton04").newInstance();
            Class<?> aClass = Class.forName("com.alice.d1_Singleton.Singleton04");
            System.out.println(aClass.getClassLoader());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

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
