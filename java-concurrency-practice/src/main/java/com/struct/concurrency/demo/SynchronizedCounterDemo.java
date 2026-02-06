package com.struct.concurrency.demo;

public class SynchronizedCounterDemo {

    private static final class Counter {
        private int value;

        public synchronized void increment() {
            value++;
        }

        public synchronized int get() {
            return value;
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
            }, "sync-worker-" + i);
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
