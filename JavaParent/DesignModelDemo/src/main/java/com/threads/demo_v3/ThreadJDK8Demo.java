package com.threads.demo_v3;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ThreadJDK8Demo {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            strings.add(UUID.randomUUID().toString());
        }

        long startTime = System.currentTimeMillis();
        // 并行流
        strings.parallelStream().forEach(str -> {
            System.out.println(str + "  " + Thread.currentThread().getName());
        });

        System.out.println("====================================");
        // 串行流
        strings.stream().forEach(str->{
            System.out.println(str + "  " + Thread.currentThread().getName());
        });
//        for (String string : strings) {
//            System.out.println(string);
//        }


        System.err.println(System.currentTimeMillis() - startTime + " ms ");

    }
}
