package com.struct.concurrency.demo;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockCounterDemo {

    private static final class Counter {
        private final ReentrantLock lock = new ReentrantLock();
        private int value;

        public void increment() {
            lock.lock();
            try {
                value++;
            } finally {
                lock.unlock();
            }
        }

        public int get() {
            lock.lock();
            try {
                return value;
            } finally {
                lock.unlock();
            }
        }
    }

    public static void run() throws InterruptedException {
        Counter counter = new Counter();

        int threads = 8;
        int loops = 50_000;

        Thread[] workers = new Thread[threads];
        for (int i = 0; i < threads; i++) {
            workers[i] = new Thread(() -> {
                for (int j = 0; j < loops; j++) {
                    counter.increment();
                }
            }, "lock-worker-" + i);
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
