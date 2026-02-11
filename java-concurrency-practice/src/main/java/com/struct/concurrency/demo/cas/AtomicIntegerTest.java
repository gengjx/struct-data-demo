package com.struct.concurrency.demo.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {

    private static int count = 0;

    private static AtomicInteger atomicInteger = new AtomicInteger(0);


    void main() {

        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                count ++;
                atomicInteger.incrementAndGet();
            }).start();
        }

        System.out.println("main count: " + count);
        System.out.println("main atomicInteger: " + atomicInteger.get());


    }


}
