package com.struct.concurrency.demo;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounterDemo {

    public static void run() throws InterruptedException {
        AtomicInteger counter = new AtomicInteger(0);

        int threads = 8;
        int loops = 50_000;

        Thread[] workers = new Thread[threads];
        for (int i = 0; i < threads; i++) {
            workers[i] = new Thread(() -> {
                for (int j = 0; j < loops; j++) {
                    counter.incrementAndGet();
                }
            }, "atomic-worker-" + i);
        }

        for (Thread t : workers) {
            t.start();
        }
        for (Thread t : workers) {
            t.join();
        }

        int expected = threads * loops;
        System.out.println("expected=" + expected + ", actual=" + counter.get());
    }
}
