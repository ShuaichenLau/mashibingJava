package com.threads.demo_v2;

public class MaktThread extends Thread {
    public static volatile Boolean flag = true;
    @Override
    public void run() {
        while (flag){

        }
    }

    public static void main(String[] args) {
        new Thread(new MaktThread()).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        flag = false;
        System.out.println(Thread.currentThread().getName() + " end");
    }
}
