package com.alice.d2_Strategy;

public class Cat implements ComparableExt<Cat> {

    private String name;
    private int age;

    public Cat(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Cat cat) {
        return 0;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
