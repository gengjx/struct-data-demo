package com.struct.concurrency.demo.cas;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerArrayTest {

    int [] array = {1,2,3,4,5};

    AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(array);

    void main() {

        atomicIntegerArray.set(0,100);

        System.out.println(atomicIntegerArray.get(0));

        atomicIntegerArray.addAndGet(1,5);

        System.out.println(atomicIntegerArray);

    }
}
