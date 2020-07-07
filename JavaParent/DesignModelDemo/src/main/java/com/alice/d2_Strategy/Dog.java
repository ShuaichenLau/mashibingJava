package com.alice.d2_Strategy;

public class Dog implements ComparableExt<Dog> {

    private int age;

    public Dog(int age) {
        this.age = age;
    }


    @Override
    public int compareTo(Dog dog) {
        if (this.age < dog.age) return -1;
        else if (this.age > dog.age) return 1;
        else return 0;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "age=" + age +
                '}';
    }
}

