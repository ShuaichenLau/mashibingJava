package com.alice.d2_Strategy;

import java.util.Arrays;

/**
 * 策略模式 排序
 *
 * @author liusc
 * 2020-7-7 20:53:41
 */
public class StrategyMain {

    public static void main(String[] args) {

        Dog[] d = {new Dog(3), new Dog(6), new Dog(2), new Dog(1)};

        Sorter sorter = new Sorter();
        sorter.stor(d);
        System.out.println(Arrays.toString(d));

    }
}
