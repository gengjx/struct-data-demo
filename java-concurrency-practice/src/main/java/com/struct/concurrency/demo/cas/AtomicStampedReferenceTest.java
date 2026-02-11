package com.struct.concurrency.demo.cas;

import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.LockSupport;

public class AtomicStampedReferenceTest {

    static void main() {
        AtomicStampedReference<Integer> stampedReference = new AtomicStampedReference(1, 1);

        new Thread(() -> {

            int value = stampedReference.getReference();
            int stamp = stampedReference.getStamp();
            System.out.println("thread1: read value: " + value + " stamp: " + stamp);
            LockSupport.parkNanos(1000000L);
            System.out.println("thread1 start......");
            boolean success = stampedReference.compareAndSet(value, value + 1, stamp, stamp + 1);
            if (success) {
                System.out.println("thread1: set value: " + (value + 1) + " stamp: " + (stamp + 1));
            } else {
                System.out.println("thread1 update failed");
            }


        }).start();


        new Thread(() -> {

            int value = stampedReference.getReference();
            int stamp = stampedReference.getStamp();
            System.out.println("thread2: read value: " + value + " stamp: " + stamp);

            stampedReference.compareAndSet(value, value + 1, stamp, stamp + 1);

            int value1 = stampedReference.getReference();
            int stamp1 = stampedReference.getStamp();
            stampedReference.compareAndSet(value, value1 - 1, stamp, stamp1 + 1);
            System.out.println("thread2: set value: " + (value1 - 1) + " stamp: " + (stamp1 + 1));

            System.out.println("Thread2 end");
        }).start();


    }

}
