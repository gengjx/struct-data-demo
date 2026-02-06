package com.struct.concurrency.demo;


public class ThreadCreationDemo {

    public static void run() throws InterruptedException {
        Thread t1 = new Thread(() -> System.out.println("platform thread: " + Thread.currentThread()), "platform-demo");
        t1.start();
        t1.join();

        Thread t2 = Thread.ofVirtual().name("virtual-demo").start(() -> System.out.println("virtual thread: " + Thread.currentThread()));
        t2.join();
    }
}
