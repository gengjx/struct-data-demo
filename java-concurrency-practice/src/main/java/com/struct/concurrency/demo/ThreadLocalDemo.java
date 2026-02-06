package com.struct.concurrency.demo;

public class ThreadLocalDemo {

    private static final ThreadLocal<Integer> LOCAL = ThreadLocal.withInitial(() -> 0);

    public static void run() throws InterruptedException {
        Thread t1 = Thread.ofVirtual().name("tl-1").start(() -> {
            LOCAL.set(100);
            System.out.println(Thread.currentThread().getName() + " local=" + LOCAL.get());
        });

        Thread t2 = Thread.ofVirtual().name("tl-2").start(() -> {
            LOCAL.set(200);
            System.out.println(Thread.currentThread().getName() + " local=" + LOCAL.get());
        });

        t1.join();
        t2.join();

        System.out.println("main local=" + LOCAL.get());
    }
}
