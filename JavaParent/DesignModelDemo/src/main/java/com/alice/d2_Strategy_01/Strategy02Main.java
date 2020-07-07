package com.alice.d2_Strategy_01;

import com.alice.d2_Strategy.Dog;

import java.util.Arrays;

public class Strategy02Main {
    public static void main(String[] args) {
        Dog[] d = {new Dog(3), new Dog(6), new Dog(2), new Dog(1)};

        Sorter<Dog> sorter = new Sorter<Dog>();
        sorter.stor(d, new DogComparable());
        System.out.println(Arrays.toString(d));
    }
}
