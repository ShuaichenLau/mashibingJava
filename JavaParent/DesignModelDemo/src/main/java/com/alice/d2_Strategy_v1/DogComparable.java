package com.alice.d2_Strategy_v1;

import com.alice.d2_Strategy.Dog;

public class DogComparable implements ComparableExt<Dog> {

    @Override
    public int compareTo(Dog t1, Dog t2) {
        if (t1.getAge() < t2.getAge()) return 1;
        else if (t1.getAge() > t2.getAge()) return -1;
        else return 0;
    }
}
