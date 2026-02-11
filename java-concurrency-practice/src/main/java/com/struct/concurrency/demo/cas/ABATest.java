package com.struct.concurrency.demo.cas;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

public class ABATest {

    static void main() {

        AtomicInteger atomicInteger = new AtomicInteger(1);

        new Thread(() -> {

            int value = atomicInteger.get();
            LockSupport.parkNanos(1000000L);
            System.out.println("Thread " + Thread.currentThread().getName() + " read value: " + value);
            boolean success =  atomicInteger.compareAndSet(value, value + 1);
            if(success){
                System.out.println("Thread " + Thread.currentThread().getName() + " " +" write success");
            }else {
                System.out.println("Thread " + Thread.currentThread().getName() + " " +" write fail");
            }
        }).start();

        new Thread(() -> {

            int value = atomicInteger.get();

            boolean success =  atomicInteger.compareAndSet(value, value + 1);

            if(success){
                System.out.println("Thread " + Thread.currentThread().getName() + " " +"write success");
            }

            value = atomicInteger.get();
            boolean isSuccess = atomicInteger.compareAndSet(value, value - 1);
            if(isSuccess){
                System.out.println("Thread " + Thread.currentThread().getName() + " " +"write success");
            }

        }).start();



    }
}
