package com.threads.demo_v4;

import sun.misc.Unsafe;

import java.util.concurrent.Callable;

public class CallableDemoV1 {
    public static void main(String[] args) {

        // 内存屏障
        Unsafe.getUnsafe().storeFence();

    }
}
