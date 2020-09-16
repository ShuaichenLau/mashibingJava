package com.threads.demo_v1;

public class ThreadDemoMain {
    public static void main(String[] args) {
        ThreadDemo01 threadDemo01 = new ThreadDemo01();
        ThreadDemo02 threadDemo02 = new ThreadDemo02();
        ThreadDemo03 threadDemo03 = new ThreadDemo03();


        try {
            threadDemo01.start();
            threadDemo01.join();
            threadDemo02.start();
            threadDemo02.join();
            threadDemo03.start();
            threadDemo03.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName());
        }

    }
}
